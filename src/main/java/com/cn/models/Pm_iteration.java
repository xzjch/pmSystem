package com.cn.models;

import com.github.tools.annotations.api.FieldDescriber;
import com.github.tools.annotations.api.Required;
import com.github.tools.annotations.mysql.AutoIncrement;
import com.github.tools.annotations.mysql.PrivateKey;

import javax.validation.constraints.Size;

public class Pm_iteration {
    @PrivateKey//私钥？
    @AutoIncrement//数据库id自增长？

    @FieldDescriber("迭代ID")
    private int iteration_id;


    @Required(false)
    @Size(max = 10)
    @FieldDescriber("迭代名称")
    private String iteration_name;

    @FieldDescriber("项目ID")
    private int project_id;

    public int getIteration_id() {
        return iteration_id;
    }

    public void setIteration_id(int iteration_id) {
        this.iteration_id = iteration_id;
    }

    public String getIteration_name() {
        return iteration_name;
    }

    public void setIteration_name(String iteration_name) {
        this.iteration_name = iteration_name;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
}
