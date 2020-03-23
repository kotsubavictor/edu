package koviiv.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Building building = new Building();
        building.setBuilding(11);
        building.setStreet("name of street");

        String json = mapper.writeValueAsString(building);
        System.out.println("json: " + json);

        Building buildingDeserialized = mapper.readValue(json, Building.class);
        System.out.println(buildingDeserialized);
    }
}
