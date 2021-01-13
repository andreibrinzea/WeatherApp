package ro.mta.se.lab.model;

import ro.mta.se.lab.CustomExceptions.InvalidCountryException;

import java.util.Map;
import java.util.TreeMap;

/**
 * Model class used for saving mapping countries names
 * with specific countries codes
 *
 * @author Andrei Brinzea
 */

public class CountryNames {
    /**
     * Members of class CountryNames
     * <i>countryNamesMap</i> used to map countries names
     * and countries codes
     * <i>countryNames_instance</i> instance of class because this
     * is a singleton class
     */
    private static final Map<String, String> countryNamesMap = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);

    private static CountryNames countryNames_instance = null;

    /**
     * <b>CountryNames</b> class constructor
     * Save mapping of values countries names - countries codes
     */
    private CountryNames() {

        countryNamesMap.put("Andorra, Principality Of", "AD");
        countryNamesMap.put("United Arab Emirates", "AE");
        countryNamesMap.put("Afghanistan, Islamic State Of", "AF");
        countryNamesMap.put("Antigua And Barbuda", "AG");
        countryNamesMap.put("Anguilla", "AI");
        countryNamesMap.put("Albania", "AL");
        countryNamesMap.put("Armenia", "AM");
        countryNamesMap.put("Netherlands Antilles", "AN");
        countryNamesMap.put("Angola", "AO");
        countryNamesMap.put("Antarctica", "AQ");
        countryNamesMap.put("Argentina", "AR");
        countryNamesMap.put("American Samoa", "AS");
        countryNamesMap.put("Austria", "AT");
        countryNamesMap.put("Australia", "AU");
        countryNamesMap.put("Aruba", "AW");
        countryNamesMap.put("Azerbaidjan", "AZ");
        countryNamesMap.put("Bosnia-Herzegovina", "BA");
        countryNamesMap.put("Barbados", "BB");
        countryNamesMap.put("Bangladesh", "BD");
        countryNamesMap.put("Belgium", "BE");
        countryNamesMap.put("Burkina Faso", "BF");
        countryNamesMap.put("Bulgaria", "BG");
        countryNamesMap.put("Bahrain", "BH");
        countryNamesMap.put("Burundi", "BI");
        countryNamesMap.put("Benin", "BJ");
        countryNamesMap.put("Bermuda", "BM");
        countryNamesMap.put("Brunei Darussalam", "BN");
        countryNamesMap.put("Bolivia", "BO");
        countryNamesMap.put("Brazil", "BR");
        countryNamesMap.put("Bahamas", "BS");
        countryNamesMap.put("Bhutan", "BT");
        countryNamesMap.put("Bouvet Island", "BV");
        countryNamesMap.put("Botswana", "BW");
        countryNamesMap.put("Belarus", "BY");
        countryNamesMap.put("Belize", "BZ");
        countryNamesMap.put("Canada", "CA");
        countryNamesMap.put("Cocos (Keeling) Islands", "CC");
        countryNamesMap.put("Central African Republic", "CF");
        countryNamesMap.put("Congo, The Democratic Republic Of The", "CD");
        countryNamesMap.put("Congo", "CG");
        countryNamesMap.put("Switzerland", "CH");
        countryNamesMap.put("Ivory Coast (Cote D'Ivoire)", "CI");
        countryNamesMap.put("Cook Islands", "CK");
        countryNamesMap.put("Chile", "CL");
        countryNamesMap.put("Cameroon", "CM");
        countryNamesMap.put("China", "CN");
        countryNamesMap.put("Colombia", "CO");
        countryNamesMap.put("Costa Rica", "CR");
        countryNamesMap.put("Former Czechoslovakia", "CS");
        countryNamesMap.put("Cuba", "CU");
        countryNamesMap.put("Cape Verde", "CV");
        countryNamesMap.put("Christmas Island", "CX");
        countryNamesMap.put("Cyprus", "CY");
        countryNamesMap.put("Czech Republic", "CZ");
        countryNamesMap.put("Germany", "DE");
        countryNamesMap.put("Djibouti", "DJ");
        countryNamesMap.put("Denmark", "DK");
        countryNamesMap.put("Dominica", "DM");
        countryNamesMap.put("Dominican Republic", "DO");
        countryNamesMap.put("Algeria", "DZ");
        countryNamesMap.put("Ecuador", "EC");
        countryNamesMap.put("Estonia", "EE");
        countryNamesMap.put("Egypt", "EG");
        countryNamesMap.put("Western Sahara", "EH");
        countryNamesMap.put("Eritrea", "ER");
        countryNamesMap.put("Spain", "ES");
        countryNamesMap.put("Ethiopia", "ET");
        countryNamesMap.put("Finland", "FI");
        countryNamesMap.put("Fiji", "FJ");
        countryNamesMap.put("Falkland Islands", "FK");
        countryNamesMap.put("Micronesia", "FM");
        countryNamesMap.put("Faroe Islands", "FO");
        countryNamesMap.put("France", "FR");
        countryNamesMap.put("France (European Territory)", "FX");
        countryNamesMap.put("Gabon", "GA");
        countryNamesMap.put("Great Britain", "UK");
        countryNamesMap.put("Grenada", "GD");
        countryNamesMap.put("Georgia", "GE");
        countryNamesMap.put("French Guyana", "GF");
        countryNamesMap.put("Ghana", "GH");
        countryNamesMap.put("Gibraltar", "GI");
        countryNamesMap.put("Greenland", "GL");
        countryNamesMap.put("Gambia", "GM");
        countryNamesMap.put("Guinea", "GN");
        countryNamesMap.put("Guadeloupe (French)", "GP");
        countryNamesMap.put("Equatorial Guinea", "GQ");
        countryNamesMap.put("Greece", "GR");
        countryNamesMap.put("S. Georgia & S. Sandwich Isls.", "GS");
        countryNamesMap.put("Guatemala", "GT");
        countryNamesMap.put("Guam (USA)", "GU");
        countryNamesMap.put("Guinea Bissau", "GW");
        countryNamesMap.put("Guyana", "GY");
        countryNamesMap.put("Hong Kong", "HK");
        countryNamesMap.put("Heard And McDonald Islands", "HM");
        countryNamesMap.put("Honduras", "HN");
        countryNamesMap.put("Croatia", "HR");
        countryNamesMap.put("Haiti", "HT");
        countryNamesMap.put("Hungary", "HU");
        countryNamesMap.put("Indonesia", "ID");
        countryNamesMap.put("Ireland", "IE");
        countryNamesMap.put("Israel", "IL");
        countryNamesMap.put("India", "IN");
        countryNamesMap.put("British Indian Ocean Territory", "IO");
        countryNamesMap.put("Iraq", "IQ");
        countryNamesMap.put("Iran", "IR");
        countryNamesMap.put("Iceland", "IS");
        countryNamesMap.put("Italy", "IT");
        countryNamesMap.put("Jamaica", "JM");
        countryNamesMap.put("Jordan", "JO");
        countryNamesMap.put("Japan", "JP");
        countryNamesMap.put("Kenya", "KE");
        countryNamesMap.put("Kyrgyz Republic (Kyrgyzstan)", "KG");
        countryNamesMap.put("Cambodia, Kingdom Of", "KH");
        countryNamesMap.put("Kiribati", "KI");
        countryNamesMap.put("Comoros", "KM");
        countryNamesMap.put("Saint Kitts & Nevis Anguilla", "KN");
        countryNamesMap.put("North Korea", "KP");
        countryNamesMap.put("South Korea", "KR");
        countryNamesMap.put("Kuwait", "KW");
        countryNamesMap.put("Cayman Islands", "KY");
        countryNamesMap.put("Kazakhstan", "KZ");
        countryNamesMap.put("Laos", "LA");
        countryNamesMap.put("Lebanon", "LB");
        countryNamesMap.put("Saint Lucia", "LC");
        countryNamesMap.put("Liechtenstein", "LI");
        countryNamesMap.put("Sri Lanka", "LK");
        countryNamesMap.put("Liberia", "LR");
        countryNamesMap.put("Lesotho", "LS");
        countryNamesMap.put("Lithuania", "LT");
        countryNamesMap.put("Luxembourg", "LU");
        countryNamesMap.put("Latvia", "LV");
        countryNamesMap.put("Libya", "LY");
        countryNamesMap.put("Morocco", "MA");
        countryNamesMap.put("Monaco", "MC");
        countryNamesMap.put("Moldavia", "MD");
        countryNamesMap.put("Madagascar", "MG");
        countryNamesMap.put("Marshall Islands", "MH");
        countryNamesMap.put("Macedonia", "MK");
        countryNamesMap.put("Mali", "ML");
        countryNamesMap.put("Myanmar", "MM");
        countryNamesMap.put("Mongolia", "MN");
        countryNamesMap.put("Macau", "MO");
        countryNamesMap.put("Northern Mariana Islands", "MP");
        countryNamesMap.put("Martinique (French)", "MQ");
        countryNamesMap.put("Mauritania", "MR");
        countryNamesMap.put("Montserrat", "MS");
        countryNamesMap.put("Malta", "MT");
        countryNamesMap.put("Mauritius", "MU");
        countryNamesMap.put("Maldives", "MV");
        countryNamesMap.put("Malawi", "MW");
        countryNamesMap.put("Mexico", "MX");
        countryNamesMap.put("Malaysia", "MY");
        countryNamesMap.put("Mozambique", "MZ");
        countryNamesMap.put("Namibia", "NA");
        countryNamesMap.put("New Caledonia (French)", "NC");
        countryNamesMap.put("Niger", "NE");
        countryNamesMap.put("Norfolk Island", "NF");
        countryNamesMap.put("Nigeria", "NG");
        countryNamesMap.put("Nicaragua", "NI");
        countryNamesMap.put("Netherlands", "NL");
        countryNamesMap.put("Norway", "NO");
        countryNamesMap.put("Nepal", "NP");
        countryNamesMap.put("Nauru", "NR");
        countryNamesMap.put("Neutral Zone", "NT");
        countryNamesMap.put("Niue", "NU");
        countryNamesMap.put("New Zealand", "NZ");
        countryNamesMap.put("Oman", "OM");
        countryNamesMap.put("Panama", "PA");
        countryNamesMap.put("Peru", "PE");
        countryNamesMap.put("Polynesia (French)", "PF");
        countryNamesMap.put("Papua New Guinea", "PG");
        countryNamesMap.put("Philippines", "PH");
        countryNamesMap.put("Pakistan", "PK");
        countryNamesMap.put("Poland", "PL");
        countryNamesMap.put("Saint Pierre And Miquelon", "PM");
        countryNamesMap.put("Pitcairn Island", "PN");
        countryNamesMap.put("Puerto Rico", "PR");
        countryNamesMap.put("Portugal", "PT");
        countryNamesMap.put("Palau", "PW");
        countryNamesMap.put("Paraguay", "PY");
        countryNamesMap.put("Qatar", "QA");
        countryNamesMap.put("Reunion (French)", "RE");
        countryNamesMap.put("Romania", "RO");
        countryNamesMap.put("Russian Federation", "RU");
        countryNamesMap.put("Rwanda", "RW");
        countryNamesMap.put("Saudi Arabia", "SA");
        countryNamesMap.put("Solomon Islands", "SB");
        countryNamesMap.put("Seychelles", "SC");
        countryNamesMap.put("Sudan", "SD");
        countryNamesMap.put("Sweden", "SE");
        countryNamesMap.put("Singapore", "SG");
        countryNamesMap.put("Saint Helena", "SH");
        countryNamesMap.put("Slovenia", "SI");
        countryNamesMap.put("Svalbard And Jan Mayen Islands", "SJ");
        countryNamesMap.put("Slovak Republic", "SK");
        countryNamesMap.put("Sierra Leone", "SL");
        countryNamesMap.put("San Marino", "SM");
        countryNamesMap.put("Senegal", "SN");
        countryNamesMap.put("Somalia", "SO");
        countryNamesMap.put("Suriname", "SR");
        countryNamesMap.put("Saint Tome (Sao Tome) And Principe", "ST");
        countryNamesMap.put("Former USSR", "SU");
        countryNamesMap.put("El Salvador", "SV");
        countryNamesMap.put("Syria", "SY");
        countryNamesMap.put("Swaziland", "SZ");
        countryNamesMap.put("Turks And Caicos Islands", "TC");
        countryNamesMap.put("Chad", "TD");
        countryNamesMap.put("French Southern Territories", "TF");
        countryNamesMap.put("Togo", "TG");
        countryNamesMap.put("Thailand", "TH");
        countryNamesMap.put("Tadjikistan", "TJ");
        countryNamesMap.put("Tokelau", "TK");
        countryNamesMap.put("Turkmenistan", "TM");
        countryNamesMap.put("Tunisia", "TN");
        countryNamesMap.put("Tonga", "TO");
        countryNamesMap.put("East Timor", "TP");
        countryNamesMap.put("Turkey", "TR");
        countryNamesMap.put("Trinidad And Tobago", "TT");
        countryNamesMap.put("Tuvalu", "TV");
        countryNamesMap.put("Taiwan", "TW");
        countryNamesMap.put("Tanzania", "TZ");
        countryNamesMap.put("Ukraine", "UA");
        countryNamesMap.put("Uganda", "UG");
        countryNamesMap.put("United Kingdom", "UK");
        countryNamesMap.put("USA Minor Outlying Islands", "UM");
        countryNamesMap.put("United States", "US");
        countryNamesMap.put("Uruguay", "UY");
        countryNamesMap.put("Uzbekistan", "UZ");
        countryNamesMap.put("Holy See (Vatican City State)", "VA");
        countryNamesMap.put("Saint Vincent & Grenadines", "VC");
        countryNamesMap.put("Venezuela", "VE");
        countryNamesMap.put("Virgin Islands (British)", "VG");
        countryNamesMap.put("Virgin Islands (USA)", "VI");
        countryNamesMap.put("Vietnam", "VN");
        countryNamesMap.put("Vanuatu", "VU");
        countryNamesMap.put("Wallis And Futuna Islands", "WF");
        countryNamesMap.put("Samoa", "WS");
        countryNamesMap.put("Yemen", "YE");
        countryNamesMap.put("Mayotte", "YT");
        countryNamesMap.put("Yugoslavia", "YU");
        countryNamesMap.put("South Africa", "ZA");
        countryNamesMap.put("Zambia", "ZM");
        countryNamesMap.put("Zaire", "ZR");
        countryNamesMap.put("Zimbabwe", "ZW");

    }

    /**
     * Function used to return instance of class
     * @return instance of class
     */
    public static CountryNames getInstance() {
        if (countryNames_instance == null) {
            countryNames_instance = new CountryNames();
        }
        return countryNames_instance;
    }

    /**
     * Function used to return country name from country code.
     * @param codeCountry country code
     * @return country code if it is valid, otherwise throws
     * an exception
     * @throws InvalidCountryException if country code is not valid
     */
    public String getCountryNamesbyCode(String codeCountry) throws InvalidCountryException {
        String countryName = "";

        for (String key : countryNamesMap.keySet()) {
            if (countryNamesMap.get(key).equals(codeCountry)) {
                countryName = key;
                break;
            }
        }

        if (countryName.equals("")) {
            throw new InvalidCountryException("Invalid code country for country code " + codeCountry + "!");
        }
        return countryName;
    }
}
