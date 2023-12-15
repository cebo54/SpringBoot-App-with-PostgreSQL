package kodlamaio.SpringBootApp.core.utilities.results;

import lombok.Data;

@Data
public class DataResult<T> extends Result{
    private T data;

    public DataResult(T data ,boolean succees, String message) {
        super(succees, message);
        this.data=data;
    }
    public DataResult(T data ,boolean succees) {
        super(succees);
        this.data=data;
    }
    public T getData(){
        return this.data;
    }

}
