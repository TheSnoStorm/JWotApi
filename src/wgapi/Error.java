package wgapi;


public class Error {
	public Error(){}
@Override
	public String toString() {
		return "message=" + message + ", field=" + field + ", value=" + value + ", code=" + code;
	}
private String field,message,value;
public String getField() {
	return field;
}
public void setField(String field) {
	this.field = field;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
private int code;

}
