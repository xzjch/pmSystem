package com.cn.models;

import com.github.tools.annotations.api.FieldDescriber;
import com.github.tools.annotations.api.Required;
import com.github.tools.annotations.mysql.AutoIncrement;
import com.github.tools.annotations.mysql.JavaBean;
import com.github.tools.annotations.mysql.PrivateKey;
import javax.validation.constraints.Size;
@JavaBean
public class Pm_bug {
    @PrivateKey
    @AutoIncrement

    @FieldDescriber("缺陷ID")
    private int bug_id;

    @Size(max = 200)
    @FieldDescriber("缺陷名称")
    @Required(true)
    private String bug_name;

    @Size(max = 200)
    @FieldDescriber("测试阶段")
    @Required(true)
    private String bug_test;


    @Size(max = 200)
    @FieldDescriber("备注")
    @Required(true)
    private String bug_rem;

    @Size(max = 200)
    @FieldDescriber("缺陷状态")
    @Required(true)
    private String bug_state;

    @Size(max = 200)
    @FieldDescriber("缺陷等级")
    @Required(true)
    private String bug_pri;

    @Size(max = 200)
    @FieldDescriber("截止时间")
    @Required(true)
    private String bug_ptime;

    @Size(max = 200)
    @FieldDescriber("缺陷认领人")
    @Required(true)
    private String bug_user;

    //@Size(max = 200)
    @FieldDescriber("项目ID")
    @Required(true)
    private int project_id;

    @Size(max = 200)
    @FieldDescriber("缺陷所属迭代")
    @Required(true)
    private String bug_spr;

    public int getBug_id() {
        return bug_id;
    }

    public void setBug_id(int bug_id) {
        this.bug_id = bug_id;
    }

    public String getBug_name() {
        return bug_name;
    }

    public void setBug_name(String bug_name) {
        this.bug_name = bug_name;
    }

    public String getBug_test() {
        return bug_test;
    }

    public void setBug_test(String bug_test) {
        this.bug_test = bug_test;
    }

    public String getBug_rem() {
        return bug_rem;
    }

    public void setBug_rem(String bug_rem) {
        this.bug_rem = bug_rem;
    }

    public String getBug_state() {
        return bug_state;
    }

    public void setBug_state(String bug_state) {
        this.bug_state = bug_state;
    }

    public String getBug_pri() {
        return bug_pri;
    }

    public void setBug_pri(String bug_pri) {
        this.bug_pri = bug_pri;
    }

    public String getBug_ptime() {
        return bug_ptime;
    }

    public void setBug_ptime(String bug_ptime) {
        this.bug_ptime = bug_ptime;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getBug_user() {
        return bug_user;
    }

    public void setBug_user(String bug_user) {
        this.bug_user = bug_user;
    }

    public String getBug_spr() {
        return bug_spr;
    }

    public void setBug_spr(String bug_spr) {
        this.bug_spr = bug_spr;
    }
}
