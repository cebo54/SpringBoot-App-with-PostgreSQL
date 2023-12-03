package kodlamaio.icardi.core.utilities.results;

import lombok.Data;


public class Result {
    private boolean succees;
    private String message;

    public Result(){}
    public Result(boolean succees){
        this.succees=succees;
    }
    public Result(boolean succees,String message){
        this(succees);
        this.message=message;
    }
    public boolean isSuccess(){
        return this.succees;
    }
    public String getMessage(){
        return this.message;
    }
}
