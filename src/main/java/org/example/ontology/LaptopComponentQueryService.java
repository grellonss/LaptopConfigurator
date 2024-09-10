package org.example.ontology;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Resource;
import org.example.configurator.*;

import java.util.ArrayList;
import java.util.List;

public class LaptopComponentQueryService {

    private SPARQLQueryExecutor queryExecutor;

    // Costruttore che accetta un esecutore di query SPARQL
    public LaptopComponentQueryService(SPARQLQueryExecutor queryExecutor) {
        this.queryExecutor = queryExecutor;
    }

    // Metodo per ottenere i componenti RAM
    public List<RAM> getRAMComponents(Laptop laptop) {
        List<RAM> ramList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?ram ?size WHERE { " +
                "?ram rdf:type laptop:RAM . " +
                "?ram laptop:hasRAMSize ?size . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource ramResource = solution.getResource("ram");
            String ramName = ramResource.getLocalName();
            String ramSize = solution.getLiteral("size").getString();
            ramList.add(new RAM(laptop, ramName, ramSize));
        }
        return ramList;
    }

    // Metodo per ottenere i componenti CPU
    public List<CPU> getCPUComponents(Laptop laptop) {
        List<CPU> cpuList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?cpu ?speed WHERE { " +
                "?cpu rdf:type laptop:CPU . " +
                "?cpu laptop:hasCPUSpeed ?speed . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource cpuResource = solution.getResource("cpu");
            String name = cpuResource.getLocalName();
            String speed = solution.getLiteral("speed").getString();
            cpuList.add(new CPU(laptop, name, speed));
        }
        return cpuList;
    }

    // Metodo per ottenere i componenti Display
    public List<Display> getDisplayComponents(Laptop laptop) {
        List<Display> displayList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?display ?resolution WHERE { " +
                "?display rdf:type laptop:Display . " +
                "?display laptop:hasDisplayResolution ?resolution . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource displayResource = solution.getResource("display");
            String name = displayResource.getLocalName();
            String resolution = solution.getLiteral("resolution").getString();
            displayList.add(new Display(laptop, name, resolution));
        }
        return displayList;
    }

    // Metodo per ottenere le Graphics Card
    public List<GraphicsCard> getGraphicsCardComponents(Laptop laptop) {
        List<GraphicsCard> graphicsCardList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?graphicsCard ?memory WHERE { " +
                "?graphicsCard rdf:type laptop:GraphicsCard . " +
                "?graphicsCard laptop:hasGraphicsMemory ?memory . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource graphicsCardResource = solution.getResource("graphicsCard");
            String name = graphicsCardResource.getLocalName();
            String memory = solution.getLiteral("memory").getString();
            graphicsCardList.add(new GraphicsCard(laptop, name, memory));
        }
        return graphicsCardList;
    }

    // Metodo per ottenere i sistemi operativi
    public List<OperatingSystem> getOperatingSystemComponents(Laptop laptop) {
        List<OperatingSystem> operatingSystemList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?operatingSystem ?version WHERE { " +
                "?operatingSystem rdf:type laptop:OperatingSystem . " +
                "?operatingSystem laptop:hasOperatingSystemVersion ?version . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource osResource = solution.getResource("operatingSystem");
            String name = osResource.getLocalName();
            String version = solution.getLiteral("version").getString();
            operatingSystemList.add(new OperatingSystem(laptop, name, version));
        }
        return operatingSystemList;
    }

    // Metodo per ottenere i componenti Storage
    public List<Storage> getStorageComponents(Laptop laptop) {
        List<Storage> storageList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?storage ?capacity WHERE { " +
                "?storage rdf:type laptop:Storage . " +
                "?storage laptop:hasStorageCapacity ?capacity . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource storageResource = solution.getResource("storage");
            String name = storageResource.getLocalName();
            String capacity = solution.getLiteral("capacity").getString();
            storageList.add(new Storage(laptop, name, capacity));
        }
        return storageList;
    }

    // Metodo per ottenere i sistemi audio
    public List<AudioSystem> getAudioSystemComponents(Laptop laptop) {
        List<AudioSystem> audioSystemList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?audioSystem ?type WHERE { " +
                "?audioSystem rdf:type laptop:AudioSystem . " +
                "?audioSystem laptop:hasAudioSystemType ?type . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource audioSystemResource = solution.getResource("audioSystem");
            String name = audioSystemResource.getLocalName();
            String type = solution.getLiteral("type").getString();
            audioSystemList.add(new AudioSystem(laptop, name, type));
        }
        return audioSystemList;
    }

    // Metodo per ottenere le batterie
    public List<Battery> getBatteryComponents(Laptop laptop) {
        List<Battery> batteryList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?battery ?capacity WHERE { " +
                "?battery rdf:type laptop:Battery . " +
                "?battery laptop:hasBatteryCapacity ?capacity . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource batteryResource = solution.getResource("battery");
            String name = batteryResource.getLocalName();
            double capacity = solution.getLiteral("capacity").getDouble();
            batteryList.add(new Battery(laptop, name, capacity));
        }
        return batteryList;
    }

    // Metodo per ottenere i colori
    public List<Colour> getColourComponents(Laptop laptop) {
        List<Colour> colourList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?colour WHERE { " +
                "?colour rdf:type laptop:Colour . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource colourResource = solution.getResource("colour");
            String name = colourResource.getLocalName();
            colourList.add(new Colour(laptop, name));
        }
        return colourList;
    }

    // Metodo per ottenere i sistemi di raffreddamento
    public List<CoolingSystem> getCoolingSystemComponents(Laptop laptop) {
        List<CoolingSystem> coolingSystemList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?coolingSystem ?type WHERE { " +
                "?coolingSystem rdf:type laptop:CoolingSystem . " +
                "?coolingSystem laptop:hasCoolingSystemType ?type . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource coolingSystemResource = solution.getResource("coolingSystem");
            String name = coolingSystemResource.getLocalName();
            String type = solution.getLiteral("type").getString();
            coolingSystemList.add(new CoolingSystem(laptop, name, type));
        }
        return coolingSystemList;
    }

    // Metodo per ottenere le garanzie
    public List<Warranty> getWarrantyComponents(Laptop laptop) {
        List<Warranty> warrantyList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?warranty ?period WHERE { " +
                "?warranty rdf:type laptop:Warranty . " +
                "?warranty laptop:hasWarrantyPeriod ?period . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource warrantyResource = solution.getResource("warranty");
            String name = warrantyResource.getLocalName();
            int period = solution.getLiteral("period").getInt();
            warrantyList.add(new Warranty(laptop, name, period));
        }
        return warrantyList;
    }

    // Metodo per ottenere i monitor esterni
    public List<ExternalMonitor> getExternalMonitorComponents(Laptop laptop) {
        List<ExternalMonitor> monitorList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?monitor ?resolution ?connection WHERE { " +
                "?monitor rdf:type laptop:ExternalMonitor . " +
                "?monitor laptop:hasExternalDisplayResolution ?resolution . " +
                "?monitor laptop:hasConnectionType ?connection . }";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource monitorResource = solution.getResource("monitor");
            String name = monitorResource.getLocalName();
            String resolution = solution.getLiteral("resolution").getString();
            String connectionType = solution.getLiteral("connection").getString();
            monitorList.add(new ExternalMonitor(laptop, connectionType, name, resolution));
        }
        return monitorList;
    }

    // Metodo per ottenere gli altoparlanti esterni
    public List<ExternalSpeaker> getExternalSpeakerComponents(Laptop laptop) {
        List<ExternalSpeaker> speakerList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?speaker ?audioType ?connection WHERE { " +
                "?speaker rdf:type laptop:ExternalSpeaker . " +
                "?speaker laptop:hasExternalAudioSystemType ?audioType . " +
                "?speaker laptop:hasConnectionType ?connection . }";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource speakerResource = solution.getResource("speaker");
            String name = speakerResource.getLocalName();
            String audioType = solution.getLiteral("audioType").getString();
            String connectionType = solution.getLiteral("connection").getString();
            speakerList.add(new ExternalSpeaker(laptop, connectionType, name, audioType));
        }
        return speakerList;
    }

    // Metodo per ottenere le tastiere
    public List<Keyboard> getKeyboardComponents(Laptop laptop) {
        List<Keyboard> keyboardList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?keyboard ?layout ?connection WHERE { " +
                "?keyboard rdf:type laptop:Keyboard . " +
                "?keyboard laptop:hasKeyboardLayout ?layout . " +
                "?keyboard laptop:hasConnectionType ?connection . }";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource keyboardResource = solution.getResource("keyboard");
            String name = keyboardResource.getLocalName();
            String layout = solution.getLiteral("layout").getString();
            String connectionType = solution.getLiteral("connection").getString();
            keyboardList.add(new Keyboard(laptop, connectionType, name, layout));
        }
        return keyboardList;
    }

    // Metodo per ottenere i mouse
    public List<Mouse> getMouseComponents(Laptop laptop) {
        List<Mouse> mouseList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?mouse ?mouseType ?connectionType WHERE { " +
                "?mouse rdf:type laptop:Mouse . " +
                "?mouse laptop:hasMouseType ?mouseType . " +
                "?mouse laptop:hasConnectionType ?connectionType . }";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource mouseResource = solution.getResource("mouse");
            String name = mouseResource.getLocalName();
            String mouseType = solution.getLiteral("mouseType").getString();
            String connectionType = solution.getLiteral("connectionType").getString();
            mouseList.add(new Mouse(laptop, connectionType, name, mouseType));
        }
        return mouseList;
    }

    // Metodo per ottenere le webcam
    public List<Webcam> getWebcamComponents(Laptop laptop) {
        List<Webcam> webcamList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?webcam ?resolution ?connection WHERE { " +
                "?webcam rdf:type laptop:Webcam . " +
                "?webcam laptop:hasWebcamResolution ?resolution . " +
                "?webcam laptop:hasConnectionType ?connection . }";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource webcamResource = solution.getResource("webcam");
            String name = webcamResource.getLocalName();
            String resolution = solution.getLiteral("resolution").getString();
            String connectionType = solution.getLiteral("connection").getString();
            webcamList.add(new Webcam(laptop, connectionType, name, resolution));
        }
        return webcamList;
    }

    // Metodo per ottenere le porte Ethernet
    public List<Ethernet> getEthernetComponents(Laptop laptop) {
        List<Ethernet> ethernetList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?ethernet ?portName ?speed WHERE { " +
                "?ethernet rdf:type laptop:Ethernet . " +
                "?ethernet laptop:hasEthernetSpeed ?speed . " +
                "?ethernet laptop:hasPortName ?portName . }";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource ethernetResource = solution.getResource("ethernet");
            String name = ethernetResource.getLocalName();
            Integer portName = solution.getLiteral("portName").getInt();
            String speed = solution.getLiteral("speed").getString();
            ethernetList.add(new Ethernet(laptop, portName, name, speed));
        }
        return ethernetList;
    }

    // Metodo per ottenere le porte USB
    public List<USB> getUSBComponents(Laptop laptop) {
        List<USB> usbList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?usb ?portName ?type WHERE { " +
                "?usb rdf:type laptop:USB . " +
                "?usb laptop:hasUSBType ?type . " +
                "?usb laptop:hasPortName ?portName . }";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource usbResource = solution.getResource("usb");
            String name = usbResource.getLocalName();
            Integer portName = solution.getLiteral("portName").getInt();
            String type = solution.getLiteral("type").getString();
            usbList.add(new USB(laptop, portName, name, type));
        }
        return usbList;
    }

    // Metodo per ottenere le porte HDMI
    public List<HDMI> getHDMIComponents(Laptop laptop) {
        List<HDMI> hdmiList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?hdmi ?portName ?version WHERE { " +
                "?hdmi rdf:type laptop:HDMI . " +
                "?hdmi laptop:hasHDMIVersion ?version . " +
                "?hdmi laptop:hasPortName ?portName . }";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource hdmiResource = solution.getResource("hdmi");
            String name = hdmiResource.getLocalName();
            Integer portName = solution.getLiteral("portName").getInt();
            String version = solution.getLiteral("version").getString();
            hdmiList.add(new HDMI(laptop, portName, name, version));
        }
        return hdmiList;
    }

    // Metodo per ottenere gli antivirus
    public List<Antivirus> getAntivirusComponents(Laptop laptop) {
        List<Antivirus> antivirusList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?antivirus ?version WHERE { " +
                "?antivirus rdf:type laptop:Antivirus . " +
                "?antivirus laptop:hasAntivirusVersion ?version . }";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource antivirusResource = solution.getResource("antivirus");
            String name = antivirusResource.getLocalName();
            String version = solution.getLiteral("version").getString();
            antivirusList.add(new Antivirus(laptop, name, version));
        }
        return antivirusList;
    }

    // Metodo per ottenere le caratteristiche di protezione
    public List<ProtectionFeature> getProtectionFeatureComponents(Laptop laptop) {
        List<ProtectionFeature> protectionFeatureList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?protectionFeature ?type WHERE { " +
                "?protectionFeature rdf:type laptop:ProtectionFeature . " +
                "?protectionFeature laptop:hasProtectionFeatureType ?type . }";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource protectionFeatureResource = solution.getResource("protectionFeature");
            String name = protectionFeatureResource.getLocalName();
            String type = solution.getLiteral("type").getString();
            protectionFeatureList.add(new ProtectionFeature(laptop, name, type));
        }
        return protectionFeatureList;
    }
}
