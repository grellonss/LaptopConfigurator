# LaptopConfiguratorApp

## Overview
The LaptopConfiguratorApp is designed to facilitate the configuration and selection of laptop components. The project leverages ontological modeling to provide a flexible and interactive interface for users to select components such as CPU, RAM, Display, Graphics Card, and more.

## Features
- **Interactive Configuration:** Allows users to choose various laptop components through an interactive graphical interface.
- **Ontology Integration:** Utilizes an ontology to manage and query laptop components, ensuring accurate and dynamic data retrieval.
- **Final Configuration Display:** Provides a summary of the user's selections, showcasing the final configuration of the chosen laptop.

## How It Works
1. **Initialization:** The application starts by loading an ontology file (`LaptopConfigModellazione.rdf`) that contains the data of available laptop components.
2. **User Choices:** Users can select components such as:
   - Audio System
   - Battery
   - Color
   - CPU
   - RAM
   - Graphics Card
   - Ports
   - Peripherals
   - Warranty
3. **Final Configuration:** After making all selections, the final configuration is displayed to the user in a structured and user-friendly format.

## Usage
1. **Run the Application:** Start the application using your preferred Java runtime environment.
2. **Follow Prompts:** The graphical interface will prompt you to make choices. Follow the instructions to configure your laptop.
3. **View Configuration:** After all selections are made, the application will display the final configuration of the laptop.

## Requirements
- **Java 11 or Higher:** Ensure you have a compatible Java version installed.
- **Jena Framework:** Used for handling RDF data and SPARQL queries.

## Installation
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/yourusername/laptop-configurator.git
   ```
2. **Navigate to the repository:**
   ```bash
   cd laptop-configurator
   ```
3. **Build the project**
   ```bash
   ./gradlew build
   ```
4. **Run the application**
   ```bash
   ./gradlew run
   ```
