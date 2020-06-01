package com.hqh.service;

import com.hqh.pojo.Notice;
import com.hqh.pojo.User;
import com.hqh.pojo.UserEvent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    /*查找所有用户信息
     *
     * @param
     * @return java.util.List<com.hqh.pojo.User>
     * @author heqianghua
     * @creed: Talk is cheap,show me the code
     * @date 2019/12/18 16:50
     */
    List<User> queryAllUser();



    /*修改用户信息
     *
     * @param user
     * @return int
     * @author heqianghua
     * @creed: Talk is cheap,show me the code
     * @date 2019/12/18 16:52
     */
    int updateUser(User user);



    /*修改用户密码
     *
     * @param password
     * @param id
     * @return int
     * @author heqianghua
     * @creed: Talk is cheap,show me the code
     * @date 2019/12/18 16:55
     */
    int updateUserPassword(String password,  int id);

    /*根据id查询个人信息
     *
     * @param id
     * @return com.hqh.pojo.User
     * @author heqianghua
     * @creed: Talk is cheap,show me the code
     * @date 2019/12/20 14:47
     */
    User queryUserById( int id);



    /*密码验证
     *
     * @param userName
    	 * @param password
     * @return com.hqh.pojo.User
     * @author heqianghua
     * @creed: Talk is cheap,show me the code
     * @date 2020/2/19 13:34
     */
    User checkLogin(String userName,String password);



    /*
     * 查询所有公告
     * @param
     * @return java.util.List<com.hqh.pojo.Notice>
     * @author heqianghua
     * @creed: Talk is cheap,show me the code
     * @date 2020/2/19 13:35
     */
    List<Notice>queryAllNotice();
    /*查询所有动态
     *
     * @param
     * @return java.util.List<com.hqh.pojo.UserEvent>
     * @author heqianghua
     * @creed: Talk is cheap,show me the code
     * @date 2020/2/19 15:40
     */
    List<UserEvent>queryAllUserEvent();

    /*新增动态
     *
     * @param userEvent
     * @return int
     * @author heqianghua
     * @creed: Talk is cheap,show me the code
     * @date 2020/2/19 15:41
     */
    int addUserEvent(UserEvent userEvent);
}
