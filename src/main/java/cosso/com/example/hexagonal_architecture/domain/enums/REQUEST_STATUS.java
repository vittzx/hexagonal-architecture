package cosso.com.example.hexagonal_architecture.domain.enums;

public enum REQUEST_STATUS {

    SUCCESS("S"),
    FAIL("E");

    private String value;

    REQUEST_STATUS(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
