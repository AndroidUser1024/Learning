package com.qinshou.commonmodule.database;

/**
 * Description:用来控制筛选条件
 * Created by 禽兽先生
 * Created on 2018/11/15
 */
public class DatabaseCondition {
    public enum Type {
        //与操作
        AND
        //等于
        , OR
    }

    public enum Condition {
        //等于
        EQUAL("==")
        //不等于
        , NOT_EQUAL("!=")
        //大于
        , GREATER_THAN(">")
        //小于
        , LESS_THAN("<")
        //大于等于
        , GREATER_THAN_OR_EQUAL(">=")
        //小于等于
        , LESS_THAN_OR_EQUAL("<=");

        //条件对应的操作符
        private String operator;

        Condition(String operator) {
            this.operator = operator;
        }

        public String getOperator() {
            return operator;
        }

        public void setOperator(String operator) {
            this.operator = operator;
        }
    }

    private String fieldName;  //条件列名对应的变量名（注意是变量名不是列名）
    private String value;   //条件值
    /**
     * Description:条件，注意该类型是拼接在该条件之前的，具体值参考 {@link Type} 枚举{
     * Date:2018/11/15
     */
    private Type mType;
    /**
     * Description:条件，具体值参考 {@link Condition} 枚举{
     * Date:2018/11/15
     */
    private Condition mCondition;

    public DatabaseCondition(String fieldName, String value) {
        this(fieldName, value, Type.AND);
    }

    public DatabaseCondition(String fieldName, String value, Type type) {
        this(fieldName, value, type, Condition.EQUAL);
    }

    public DatabaseCondition(String fieldName, String value, Type type, Condition condition) {
        this.fieldName = fieldName;
        this.value = value;
        this.mType = type;
        this.mCondition = condition;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Type getType() {
        return mType;
    }

    public void setType(Type type) {
        mType = type;
    }

    public Condition getCondition() {
        return mCondition;
    }

    public void setCondition(Condition condition) {
        mCondition = condition;
    }

    @Override
    public String toString() {
        return "DatabaseCondition{" +
                "fieldName='" + fieldName + '\'' +
                ", value='" + value + '\'' +
                ", mType=" + mType +
                ", mCondition=" + mCondition +
                '}';
    }
}
