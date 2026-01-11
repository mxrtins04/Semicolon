package data.model;

public enum BankCode {
    ACCESS_BANK("044", "Access Bank"),
    AFRIBANK("014", "Afribank"),
    CITIBANK("023", "Citibank"),
    DIAMOND_BANK("063", "Diamond Bank"),
    ECOBANK("050", "Ecobank"),
    ETB("040", "Equitorial Trust Bank"),
    FIRST_BANK("011", "First Bank of Nigeria"),
    FCMB("214", "First City Monument Bank"),
    FIDELITY("070", "Fidelity Bank"),
    FINBANK("085", "Finbank"),
    GTB("058", "Guaranty Trust Bank"),
    INTERCONTINENTAL("069", "Intercontinental Bank"),
    OCEANIC("056", "Oceanic Bank"),
    BANKPHB("082", "BankPhb"),
    SKYE("076", "Skye Bank"),
    SPRINGBANK("084", "SpringBank"),
    STANBIC("221", "Stanbic IBTC Bank"),
    STANDARD_CHARTERED("068", "Standard Chartered Bank"),
    STERLING("232", "Sterling Bank"),
    UBA("033", "United Bank for Africa"),
    UNION_BANK("032", "Union Bank"),
    WEMA("035", "Wema Bank"),
    ZENITH("057", "Zenith Bank"),
    UNITY("215", "Unity Bank");

    private final String code;
    private final String name;

    BankCode(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() { return code; }
    public String getName() { return name; }

    public static BankCode fromCode(String code) {
        for (BankCode bank : values()) {
            if (bank.code.equals(code)) return bank;
        }
        return null;
    }
    
    public static BankCode[] getAllCodes() {
        return values();
    }
}
