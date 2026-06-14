package game.lifeline;

public enum LifelineType {
    FIFTY_FIFTY("1"),
    PHONE_A_FRIEND("2"),
    ASK_AUDIENCE("3");

    private final String id;

    LifelineType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static LifelineType fromInt(String value) {
        for (LifelineType type : LifelineType.values()) {
            if (type.id.equals(value)) {
                return type;
            }
        }
        return null;
    }
}
