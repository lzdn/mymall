package edu.ccnt.mymall.dao;

import edu.ccnt.mymall.model.User;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mmall_user
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mmall_user
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mmall_user
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mmall_user
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mmall_user
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mmall_user
     *
     * @mbg.generated Wed Aug 02 21:00:02 CST 2017
     */
    int updateByPrimaryKey(User record);
}