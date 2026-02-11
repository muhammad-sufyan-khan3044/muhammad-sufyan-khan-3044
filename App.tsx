
import React, { useState, useEffect, useRef, useCallback } from 'react';
import { Sidebar } from './components/Sidebar';
import { ChatMessage } from './components/ChatMessage';
import { ChatInput } from './components/ChatInput';
import { Message, ChatSession } from './types';
import { geminiService } from './services/gemini';

const MODELS = [
  { id: 'gemini-3-pro-preview', name: 'ChatGPT Pro', desc: 'Maximum intelligence & complex reasoning' },
  { id: 'gemini-3-flash-preview', name: 'Gemini 3 Flash', desc: 'Real-time speed & efficiency' },
  { id: 'gemini-flash-lite-latest', name: 'Gemini Flash Lite', desc: 'Lightweight & cost effective' },
  { id: 'gemini-2.5-flash-native-audio-preview-12-2025', name: 'Native Audio', desc: 'Direct voice & audio interaction' },
  { id: 'gemini-2.5-flash-preview-tts', name: 'Gemini TTS', desc: 'Speech optimized generation' },
  { id: 'gemini-2.5-flash-image', name: 'Gemini Image', desc: 'Creative visual tasks' }
];

const App: React.FC = () => {
  const [sessions, setSessions] = useState<ChatSession[]>([]);
  const [currentSessionId, setCurrentSessionId] = useState<string>('');
  const [selectedModel, setSelectedModel] = useState(MODELS[0].id);
  const [userName, setUserName] = useState('John Doe');
  const [isTyping, setIsTyping] = useState(false);
  const [error, setError] = useState<string | null>(null);
  const [showModelMenu, setShowModelMenu] = useState(false);
  const [shareStatus, setShareStatus] = useState<'idle' | 'copied' | 'error'>('idle');
  const scrollRef = useRef<HTMLDivElement>(null);

  useEffect(() => {
    const initialId = Date.now().toString();
    const newSession: ChatSession = {
      id: initialId,
      title: 'Initial Conversation',
      messages: [],
      createdAt: new Date(),
    };
    setSessions([newSession]);
    setCurrentSessionId(initialId);
  }, []);

  const currentSession = sessions.find(s => s.id === currentSessionId);

  const scrollToBottom = useCallback(() => {
    if (scrollRef.current) {
      scrollRef.current.scrollTo({
        top: scrollRef.current.scrollHeight,
        behavior: 'smooth'
      });
    }
  }, []);

  useEffect(() => {
    scrollToBottom();
  }, [currentSession?.messages, isTyping, scrollToBottom]);

  const handleSendMessage = async (text: string) => {
    if (!currentSession) return;

    const userMessage: Message = {
      id: Date.now().toString(),
      role: 'user',
      content: text,
      timestamp: new Date(),
    };

    const isFirstMessage = currentSession.messages.length === 0;
    const updatedSessions = sessions.map(s => {
      if (s.id === currentSessionId) {
        return {
          ...s,
          title: isFirstMessage ? (text.slice(0, 30) + (text.length > 30 ? '...' : '')) : s.title,
          messages: [...s.messages, userMessage],
        };
      }
      return s;
    });

    setSessions(updatedSessions);
    setIsTyping(true);
    setError(null);

    try {
      const assistantId = (Date.now() + 1).toString();
      const assistantMessage: Message = {
        id: assistantId,
        role: 'assistant',
        content: '',
        timestamp: new Date(),
      };

      setSessions(prev => prev.map(s => 
        s.id === currentSessionId 
          ? { ...s, messages: [...s.messages, assistantMessage] }
          : s
      ));

      let fullResponse = '';
      const messageHistory = [...currentSession.messages, userMessage];
      const stream = geminiService.sendMessageStream(messageHistory, selectedModel);

      for await (const chunk of stream) {
        fullResponse += chunk;
        setSessions(prev => prev.map(s => 
          s.id === currentSessionId 
            ? {
                ...s,
                messages: s.messages.map(m => 
                  m.id === assistantId ? { ...m, content: fullResponse } : m
                )
              }
            : s
        ));
      }
    } catch (err: any) {
      setError("Model connectivity error. Please verify your connection or try another model.");
      console.error(err);
    } finally {
      setIsTyping(false);
    }
  };

  const handleNewChat = () => {
    const newId = Date.now().toString();
    const newSession: ChatSession = {
      id: newId,
      title: 'New Chat',
      messages: [],
      createdAt: new Date(),
    };
    setSessions(prev => [newSession, ...prev]);
    setCurrentSessionId(newId);
    setError(null);
  };

  const handleDeleteSession = (id: string) => {
    const filtered = sessions.filter(s => s.id !== id);
    if (filtered.length === 0) {
      handleNewChat();
    } else {
      setSessions(filtered);
      if (currentSessionId === id) {
        setCurrentSessionId(filtered[0].id);
      }
    }
  };

  const handleClearAll = () => {
    setSessions([]);
    handleNewChat();
  };

  const handleShare = async () => {
    if (!currentSession || currentSession.messages.length === 0) {
      setShareStatus('error');
      setTimeout(() => setShareStatus('idle'), 2000);
      return;
    }
    
    const shareText = `--- AI Chat Log: ${currentSession.title} ---\n\n` + 
      currentSession.messages.map(m => {
        const time = m.timestamp.toLocaleTimeString();
        const sender = m.role === 'assistant' ? 'ChatGPT Pro' : userName;
        return `[${time}] ${sender}:\n${m.content}`;
      }).join('\n\n') + 
      `\n\nGenerated with ChatGPT Clone Powered by Gemini.`;
    
    try {
      if (navigator.share) {
        await navigator.share({
          title: currentSession.title,
          text: shareText,
        });
        setShareStatus('copied');
      } else {
        await navigator.clipboard.writeText(shareText);
        setShareStatus('copied');
      }
    } catch (e) {
      console.error("Sharing failed", e);
      setShareStatus('error');
    } finally {
      setTimeout(() => setShareStatus('idle'), 2000);
    }
  };

  return (
    <div className="flex h-screen w-full overflow-hidden font-sans transition-colors duration-300">
      <Sidebar 
        sessions={sessions} 
        currentSessionId={currentSessionId} 
        onSelectSession={setCurrentSessionId}
        onNewChat={handleNewChat}
        onDeleteSession={handleDeleteSession}
        onClearAll={handleClearAll}
        userName={userName}
        onUpdateUserName={setUserName}
      />

      <div className="flex-1 flex flex-col relative h-full bg-inherit">
        {/* Header with Model Selector */}
        <header className="h-16 border-b border-black/10 dark:border-white/10 flex items-center justify-between px-6 sticky top-0 bg-transparent backdrop-blur-xl z-[60]">
          <div className="flex items-center gap-4">
            <div className="relative">
              <button 
                onClick={() => setShowModelMenu(!showModelMenu)}
                className="flex items-center gap-2.5 px-3 py-2 hover:bg-black/5 dark:hover:bg-white/5 rounded-xl transition-all border border-transparent hover:border-black/10 dark:hover:border-white/10"
              >
                <div className={`w-7 h-7 rounded-lg flex items-center justify-center shadow-lg ${selectedModel === 'gemini-3-pro-preview' ? 'bg-indigo-600' : 'bg-[#10a37f]'}`}>
                  <i className="fa-solid fa-bolt-lightning text-white text-[12px]"></i>
                </div>
                <span className="font-extrabold tracking-tight text-inherit">
                  {MODELS.find(m => m.id === selectedModel)?.name}
                </span>
                <i className={`fa-solid fa-chevron-down text-[10px] text-gray-500 transition-transform ${showModelMenu ? 'rotate-180' : ''}`}></i>
              </button>

              {showModelMenu && (
                <div className="absolute top-full left-0 mt-3 w-80 bg-white dark:bg-[#171717] border border-black/10 dark:border-white/10 rounded-3xl shadow-2xl py-3 z-[70] animate-in fade-in slide-in-from-top-2 overflow-hidden">
                  <p className="px-5 py-2 text-[10px] font-bold text-gray-400 uppercase tracking-widest border-b border-black/5 dark:border-white/5 mb-2">
                    Select AI Model
                  </p>
                  <div className="max-h-[60vh] overflow-y-auto custom-scrollbar px-2 space-y-1">
                    {MODELS.map((model) => (
                      <button
                        key={model.id}
                        onClick={() => {
                          setSelectedModel(model.id);
                          setShowModelMenu(false);
                        }}
                        className={`w-full text-left px-4 py-3 hover:bg-gray-100 dark:hover:bg-white/5 rounded-2xl flex flex-col transition-colors ${selectedModel === model.id ? 'bg-gray-100 dark:bg-white/5 border border-black/10 dark:border-white/10 shadow-sm' : 'border border-transparent'}`}
                      >
                        <div className="flex items-center justify-between w-full">
                          <span className={`font-bold ${selectedModel === model.id ? 'text-indigo-600' : 'text-inherit opacity-90'}`}>{model.name}</span>
                          {selectedModel === model.id && <i className="fa-solid fa-circle-check text-indigo-500 text-sm"></i>}
                        </div>
                        <span className="text-[11px] text-gray-400 font-medium leading-snug mt-1">{model.desc}</span>
                      </button>
                    ))}
                  </div>
                </div>
              )}
            </div>
          </div>
          
          <div className="flex items-center gap-3">
            <button 
              onClick={handleShare}
              className={`flex items-center gap-2 px-5 py-2 border rounded-2xl transition-all text-xs font-bold shadow-sm hover:scale-[1.02] active:scale-95 ${
                shareStatus === 'copied' 
                  ? 'bg-emerald-600 text-white border-emerald-600' 
                  : shareStatus === 'error'
                  ? 'bg-red-600 text-white border-red-600'
                  : 'bg-white dark:bg-white/5 border-black/20 dark:border-white/10 hover:bg-gray-100 dark:hover:bg-white/10 text-inherit'
              }`}
            >
              <i className={`fa-solid ${shareStatus === 'copied' ? 'fa-check' : shareStatus === 'error' ? 'fa-xmark' : 'fa-arrow-up-from-bracket'}`}></i>
              {shareStatus === 'copied' ? 'Shared!' : shareStatus === 'error' ? 'Failed' : 'Share'}
            </button>
          </div>
        </header>

        {/* Message Container */}
        <div 
          ref={scrollRef}
          className="flex-1 overflow-y-auto scroll-smooth pb-48 pt-8 custom-scrollbar"
        >
          {currentSession?.messages.length === 0 ? (
            <div className="h-full flex flex-col items-center justify-center p-8 space-y-10 animate-in fade-in duration-1000">
              <div className="w-24 h-24 bg-gradient-to-tr from-[#10a37f] to-emerald-400 rounded-[2.5rem] flex items-center justify-center shadow-2xl shadow-emerald-500/20 rotate-3">
                <i className="fa-solid fa-sparkles text-4xl text-white"></i>
              </div>
              <div className="text-center space-y-3">
                <h1 className="text-4xl md:text-6xl font-black tracking-tighter text-inherit body-light-theme:text-black">How can I help you, {userName.split(' ')[0]}?</h1>
                <p className="text-gray-500 font-bold max-w-sm mx-auto opacity-70">
                  Using <span className="text-indigo-600 dark:text-indigo-400">{MODELS.find(m => m.id === selectedModel)?.name}</span>
                </p>
              </div>
              
              <div className="grid grid-cols-1 sm:grid-cols-2 gap-4 max-w-3xl w-full px-6">
                {[
                  { icon: 'fa-wand-magic-sparkles', text: 'Write a professional email' },
                  { icon: 'fa-code', text: 'Explain React state management' },
                  { icon: 'fa-earth-americas', text: 'Plan a travel itinerary' },
                  { icon: 'fa-brain-circuit', text: 'Solve a complex logic puzzle' }
                ].map((hint) => (
                  <button 
                    key={hint.text}
                    onClick={() => handleSendMessage(hint.text)}
                    className="p-6 bg-white dark:bg-white/5 border border-black/10 dark:border-white/10 rounded-[2rem] text-left transition-all hover:-translate-y-2 hover:shadow-2xl active:scale-95 group shadow-sm body-light-theme:hover:border-indigo-400"
                  >
                    <div className="w-10 h-10 rounded-2xl bg-gray-50 dark:bg-white/5 flex items-center justify-center mb-4 group-hover:bg-indigo-500/20 transition-colors">
                      <i className={`fa-solid ${hint.icon} text-gray-400 group-hover:text-indigo-600 dark:group-hover:text-indigo-400 text-lg`}></i>
                    </div>
                    <p className="font-extrabold text-[15px] opacity-90 group-hover:opacity-100 body-light-theme:text-black">{hint.text}</p>
                  </button>
                ))}
              </div>
            </div>
          ) : (
            <div className="max-w-4xl mx-auto w-full">
              {currentSession?.messages.map((m) => (
                <ChatMessage key={m.id} message={m} userName={userName} />
              ))}
            </div>
          )}
          
          {error && (
            <div className="max-w-2xl mx-auto px-6 py-8">
              <div className="bg-red-500/10 border border-red-500/20 text-red-600 dark:text-red-400 p-6 rounded-[2rem] text-sm flex items-center gap-5 shadow-2xl backdrop-blur-md">
                <i className="fa-solid fa-triangle-exclamation text-2xl"></i>
                <div className="flex-1">
                  <p className="font-black text-xs uppercase tracking-widest mb-1">System Error</p>
                  <p className="font-medium opacity-90">{error}</p>
                </div>
                <button onClick={() => setError(null)} className="p-3 hover:bg-black/5 dark:hover:bg-white/10 rounded-full transition-colors">
                  <i className="fa-solid fa-xmark"></i>
                </button>
              </div>
            </div>
          )}
        </div>

        {/* Input Bar Section */}
        <div className="absolute bottom-0 left-0 w-full bg-gradient-to-t from-white dark:from-[#0d0d0d] via-white/80 dark:via-[#0d0d0d]/80 to-transparent pt-16 pb-10 px-6 pointer-events-none">
          <div className="max-w-3xl mx-auto pointer-events-auto">
            <ChatInput 
              onSend={handleSendMessage} 
              disabled={isTyping} 
              placeholder={`Ask ${MODELS.find(m => m.id === selectedModel)?.name.split(' ')[0]} anything...`}
            />
            <div className="mt-5 flex items-center justify-center gap-5 text-[10px] font-black text-gray-400 dark:text-gray-500 uppercase tracking-[0.2em] opacity-60">
              <span className="flex items-center gap-1.5"><i className="fa-solid fa-shield-halved text-[8px]"></i> Private</span>
              <div className="w-1.5 h-1.5 bg-current rounded-full opacity-20"></div>
              <span className="flex items-center gap-1.5"><i className="fa-solid fa-lock text-[8px]"></i> Secure Session</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default App;
