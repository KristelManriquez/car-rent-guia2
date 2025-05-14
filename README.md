# 🚗 Sistema de Arriendo de Vehículos

Aplicación de escritorio en Java para gestionar arriendos de vehículos con sistema de cuotas, validación de clientes, pagos, y control de disponibilidad de vehículos. Desarrollado aplicando principios de Programación Orientada a Objetos (POO).

---

## ✅ Funcionalidades implementadas

### 🧾 Cálculo de monto a pagar

Calcula el monto total del arriendo multiplicando los días por el precio diario.
🧠 **Clase:** `Arriendo`
👤 **Responsable:** JOACO

---

### ✔️ Evaluación del arriendo

Antes de confirmar el arriendo, se valida que:

- El cliente esté vigente
- El vehículo tenga condición `'D'` (disponible)
  Retorna `true` si es válido.
  🧠 **Clase:** `Arriendo`
  👤 **Responsable:** JOACO

---

### ➕ Agregar cliente

Permite agregar clientes desde la interfaz. Se almacenan en el `ArrayList` y en archivo.
Regresa automáticamente a la interfaz de arriendo.
🧠 **Interfaz:** `ClientesGUI`
👤 **Responsable:** Kristel

---

### 💳 Generación de cuotas del arriendo

Genera una lista de cuotas:

- Correlativo desde 1
- Monto proporcional dividido entre cuotas
- Última cuota ajusta redondeo
- Todas con `pagada = false` al inicio
  🧠 **Clase:** `ArriendoCuota`
  👤 **Responsable:** KAT

---

### 📦 Ingreso de arriendo con cuotas

Evalúa el arriendo, y si es válido:

- Cambia estado del vehículo a `'A'` (arrendado)
- Asigna cuotas generadas al arriendo
  🧠 **Clase:** `ArriendoCuota`
  👤 **Responsable:** KAT

---

### 💰 Pagar cuota

Busca una cuota por número. Si no fue pagada, actualiza su estado a `true`.
Retorna `true` si fue exitosa.
🧠 **Clase:** `CuotaArriendo`
👤 **Responsable:** JOACO

---

## 📘 Validaciones generales

### ✔️ Validaciones de atributos en setters

Todos los atributos se validan al asignarse vía `setters`.

- Por ejemplo, `Cliente` valida formato de cédula con regex.
  🧠 **Todas las clases**
  👤 **Responsable:** KENNY

---

### 📢 Método para mostrar mensajes

Las clases pueden entregar mensajes amigables al usuario, con tipo (`INFO`, `ERROR`, etc.).
🧠 **Aplicado en lógica e interfaz**
👤 **Responsable:** KENNY

---

## 🖥️ Interfaz gráfica principal

🧠 **Clase principal:** `MainGUI`
👤 **Responsable:** CARLOS

### Componentes:

- ✅ **Barra de menús** con opciones:

  - "Arrendar con cuotas"
  - "Pagar cuota"
  - "Salir"
- ✅ **Título** e **imagen** representativa del sistema
- ✅ **Botones** accesos rápidos para cada funcionalidad
- ✅ Carga automática de:

  - Clientes
  - Vehículos
  - Arriendos con cuotas

[](https://)

```

```
