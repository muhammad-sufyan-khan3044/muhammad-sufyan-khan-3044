public class Employee {
    private String name;
    private Date dateOfBirth;
    private Date dateOfJoining;

    public Employee(String name, Date dob, Date doj) {
        this.name = name;
        this.dateOfBirth = dob;
        this.dateOfJoining = doj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    // Check if joined within last 5 years from 2012
    boolean joinedWithinLastFiveYears() {
        int currentYear = 2012;
        return dateOfJoining.getYear() >= currentYear - 5;
    }

    // Check if employee is less than 40 years old in 2012
    boolean isYoungerThan40() {
        int currentYear = 2012;
        int age = currentYear - dateOfBirth.getYear();
        return age < 40;
    }
}
