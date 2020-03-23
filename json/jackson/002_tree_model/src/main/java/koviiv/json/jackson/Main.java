package koviiv.json.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(Main.class.getClassLoader().getResourceAsStream("tree_model.json"));

        System.out.println("----------------------------");

        System.out.printf("Name: %s \n", rootNode.get("name").textValue());
        System.out.printf("Version: %s \n", rootNode.get("version").textValue());

        System.out.println("----------------------------");

        Iterator<JsonNode> nodes = rootNode.iterator();
        JsonNode node;
        while (nodes.hasNext()) {
            node = nodes.next();
            System.out.println(node.getNodeType());
            System.out.println(node.textValue());
        }

        System.out.println("----------------------------");

        JsonNode serviceNode = rootNode.get("service");
        if (serviceNode.isContainerNode()) {
            System.out.printf("service.name = %s \n", serviceNode.get("name").textValue());
        }

        System.out.println("----------------------------");

        JsonNode dependenciesNode = rootNode.get("dependencies");
        if (dependenciesNode.isArray()) {
            System.out.println("dependencies is an array");
        }

    }
}
