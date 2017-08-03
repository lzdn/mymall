package edu.ccnt.mymall.model;

import java.util.Date;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_user.id
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_user.username
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_user.password
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_user.email
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_user.phone
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_user.question
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    private String question;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_user.answer
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    private String answer;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_user.role
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    private Integer role;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_user.create_time
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mmall_user.update_time
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_user.id
     *
     * @return the value of mmall_user.id
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_user.id
     *
     * @param id the value for mmall_user.id
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_user.username
     *
     * @return the value of mmall_user.username
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_user.username
     *
     * @param username the value for mmall_user.username
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_user.password
     *
     * @return the value of mmall_user.password
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_user.password
     *
     * @param password the value for mmall_user.password
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_user.email
     *
     * @return the value of mmall_user.email
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_user.email
     *
     * @param email the value for mmall_user.email
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_user.phone
     *
     * @return the value of mmall_user.phone
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_user.phone
     *
     * @param phone the value for mmall_user.phone
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_user.question
     *
     * @return the value of mmall_user.question
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    public String getQuestion() {
        return question;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_user.question
     *
     * @param question the value for mmall_user.question
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_user.answer
     *
     * @return the value of mmall_user.answer
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_user.answer
     *
     * @param answer the value for mmall_user.answer
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_user.role
     *
     * @return the value of mmall_user.role
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    public Integer getRole() {
        return role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_user.role
     *
     * @param role the value for mmall_user.role
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    public void setRole(Integer role) {
        this.role = role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_user.create_time
     *
     * @return the value of mmall_user.create_time
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_user.create_time
     *
     * @param createTime the value for mmall_user.create_time
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mmall_user.update_time
     *
     * @return the value of mmall_user.update_time
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mmall_user.update_time
     *
     * @param updateTime the value for mmall_user.update_time
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}