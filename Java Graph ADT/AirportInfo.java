//
//  Name:       Casuga, Joshua
//  Project:    #5
//  Due:        12/9/2022
//  Course:     cs-2400-01-f22
//
//  Description: AirportInfo class that formats the data from airports.csv
//
public class AirportInfo {
    private String code;
    private String name;
    private String city;
    private String state;

    public AirportInfo(String code, String name, String city, String state) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", name, city, state);
    }
}
