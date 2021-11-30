package profile;

import Admin.AdminProfileUpdate;
import Admin.AdminProfileView;
import java.sql.Date;

//Admin Object Class
public class AdminProfile {

    private int experience;
    private int age;
    private int salary;
    private String id;
    private String firstName;
    private String lastName;
    private Date dob;
    private Date joinDate;
    private String martialStatus;
    private String contactNumber;
    private String gender;
    private String permanentAddress;
    private String temporaryAddress;
    private String state;
    private String district;
    private String designation;

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDob() {
        return dob;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public int getExperience() {
        return experience;
    }

    public int getAge() {
        return age;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public String getTemporaryAddress() {
        return temporaryAddress;
    }

    public int getSalary() {
        return salary;
    }

    public String getState() {
        return state;
    }

    public String getDistrict() {
        return district;
    }

    public String getDesignation() {
        return designation;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public void setTemporaryAddress(String temporaryAddress) {
        this.temporaryAddress = temporaryAddress;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    //Function to set Admin Profile Page
    public static void setAdminProfile(String id) {
        AdminProfile details = Database.DatabaseOperations.getAdminProfile(id);
        AdminProfileView.UserNameValue.setText(details.id);
        AdminProfileView.ContactNoValue.setText(details.getContactNumber());
        AdminProfileView.DOBValue.setText(details.getDob().toString());
        AdminProfileView.AgeValue.setText(Integer.toString(details.getAge()));
        AdminProfileView.JoinDateValue.setText(details.getJoinDate().toString());
        AdminProfileView.PAddressValue.setText(details.getPermanentAddress());
        AdminProfileView.TAddressValue.setText(details.getTemporaryAddress());
        AdminProfileView.MaritalValue.setText(details.getMartialStatus());
        AdminProfileView.DesignationValue.setText(details.getDesignation());
        AdminProfileView.ExperienceValue.setText(Integer.toString(details.getExperience()));
        AdminProfileView.GenderValue.setText(details.getGender());
        AdminProfileView.SalaryValue.setText(Integer.toString(details.getSalary()));
        AdminProfileView.UserNameTop.setText(details.getFirstName() + " " + details.getLastName());
    }

    //Function to set AdminProfileUpdate Page   
    public static void setAdminProfileUpdate(String id) {
        AdminProfile details = Database.DatabaseOperations.getAdminProfile(id);
        int a = 0;
        if (details.getMartialStatus().equals("Single")) {
            a = 0;
        } else if (details.getMartialStatus().equals("Married")) {
            a = 1;
        } else if (details.getMartialStatus().equals("Divorced")) {
            a = 1;
        }
        AdminProfileUpdate.firstNameValue.setText(details.getFirstName());
        AdminProfileUpdate.lastNameValue.setText(details.getLastName());
        AdminProfileUpdate.DOBValue.setText(details.getDob().toString());
        AdminProfileUpdate.ageValue.setText(Integer.toString(details.getAge()));
        AdminProfileUpdate.contactNoValue.setText(details.getContactNumber());
        AdminProfileUpdate.pAddressValue.setText(details.getPermanentAddress());
        AdminProfileUpdate.tAddressValue.setText(details.getTemporaryAddress());
        AdminProfileUpdate.martialValue.setSelectedIndex(a);
        AdminProfileUpdate.salaryValue.setText(Integer.toString(details.getSalary()));
        AdminProfileUpdate.stateValue.setText(details.getState());
        AdminProfileUpdate.districtValue.setText(details.getDistrict());
        AdminProfileUpdate.designationValue.setText(details.getDesignation());
        AdminProfileUpdate.UserNameTop.setText(details.getId());
    }
}
