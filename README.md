# Aplicación Completa: Gestión de Descuentos, Dados y Películas (Práctica de Desarrollo con TDD)

Esta aplicación es una práctica de desarrollo que utiliza la metodología de Desarrollo Guiado por Pruebas (TDD, por sus siglas en inglés), empleando JUnit y Mockito para las pruebas unitarias y de integración. Proporciona funcionalidades para la gestión de descuentos en productos, lanzamiento de dados y gestión de películas.

## Módulo de Descuentos

El módulo de descuentos permite calcular precios totales aplicando descuentos a productos.

### Funcionalidades

- **PriceCalculator**: Clase principal para calcular precios totales con o sin descuento.
- **PriceCalculatorTest**: Pruebas unitarias utilizando JUnit y Mockito para verificar el comportamiento del calculador de precios.

## Módulo de Dados

El módulo de dados simula el lanzamiento de dados y proporciona funcionalidades relacionadas.

### Funcionalidades

- **Dice**: Clase para simular el lanzamiento de un dado.
- **Player**: Clase que representa a un jugador en un juego de dados.
- **PlayerTest**: Pruebas unitarias utilizando JUnit y Mockito para verificar el comportamiento del jugador en el juego de dados.

## Módulo de Películas

El módulo de películas gestiona la información de películas y proporciona funcionalidades relacionadas.

### Funcionalidades

- **Movie**: Clase que representa una película con su título, duración, género y director.
- **MovieRepository**: Interfaz para acceder a la información de las películas.
- **MovieService**: Clase que proporciona métodos para buscar películas por diferentes criterios.
- **MovieRepositoryIntegrationTest**: Pruebas de integración utilizando JUnit y Mockito para verificar el acceso a la base de datos de películas.

## Configuración y Uso

1. Clona el repositorio de la aplicación.
2. Instala las dependencias si es necesario.
3. Ejecuta las pruebas unitarias y de integración para verificar el correcto funcionamiento de la aplicación.
4. Utiliza las clases y funcionalidades proporcionadas en tu propia aplicación según sea necesario.

