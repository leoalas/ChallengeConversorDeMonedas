# 💱 Conversor de Moneda

Este es un proyecto desarrollado como parte del programa **Oracle Next Education - Alura LATAM**. El objetivo es construir una aplicación en Java que permita convertir valores entre distintas monedas utilizando datos en tiempo real desde una API pública.

---

## 📌 Descripción

El **Conversor de Moneda** es una aplicación de consola escrita en Java que:

- Consulta tasas de cambio en tiempo real desde la API de [ExchangeRate-API](https://www.exchangerate-api.com/).
- Permite al usuario seleccionar una moneda de origen y una moneda de destino.
- Calcula y muestra el valor convertido en base a una cantidad ingresada.
- Presenta un menú interactivo en la consola para múltiples conversiones.

---

## 🚀 Funcionalidades

- 📤 Menú interactivo para elegir monedas.
- 📡 Consulta a una API externa con `HttpClient`.
- 💰 Cálculo preciso de la conversión entre monedas.
- 🔁 Bucle de repetición para realizar múltiples operaciones.
- ❌ Manejo de errores básicos para opciones inválidas y fallas de red.

---

## 🧪 Tecnologías utilizadas

- ✅ Java 17+
- ✅ API pública [ExchangeRate-API](https://www.exchangerate-api.com/)
- ✅ Gson (para procesar JSON)
- ✅ Consola (interfaz textual con `Scanner`)

---

## 💻 Cómo ejecutar este proyecto

### 1. Clona el repositorio

```bash
git clone https://github.com/leoalas/ChallengeConversorDeMonedas
