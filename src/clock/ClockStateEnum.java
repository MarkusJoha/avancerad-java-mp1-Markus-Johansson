package clock;

public enum ClockStateEnum {
    DISPLAY_TIME("Display Time (S1)"),
    DISPLAY_DATE("Display Date (S2)"),
    CHANGE_TIME("Change Time (S3)"),
    CHANGE_DATE("Change Date (S4)");

    private final String description;

    ClockStateEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
