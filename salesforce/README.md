# Mimo · Configuración de Salesforce

Metadatos de la org de Salesforce (Service Cloud, Developer Edition) que usa **Mimo** como *back office* de las protectoras. El personal de cada centro gestiona aquí las solicitudes y los animales. La app y el backend (Spring Boot) nunca hablan con Salesforce directamente desde el cliente: todo pasa por la API REST.

## Qué contiene

| Elemento | Descripción |
|---|---|
| **Objetos** | `Animal__c` (con Record Types por especie: perro, gato, exótico), `Raza__c`, y personalizaciones de `Account` (centro), `Contact` (adoptante/acogedor) y `Case` (solicitud) |
| **Perfil** | `Personal de centro` (acceso mínimo, los permisos van en permission sets) |
| **Permission sets** | `Empleado de centro`, `Gestor de centro` e `Integración Mimo` (usuario de integración del backend) |
| **Roles y sharing rules** | Un rol por centro y reglas de compartición para que cada centro vea solo sus animales y solicitudes |
| **Flow** | `Case_Rellenar_centro_clave`: rellena el centro de cada solicitud a partir del animal |
| **App** | Aplicación Lightning `Mimo` |

## Visibilidad por centro

Los *sharing rules* no permiten usar relaciones (lookups) como criterio, así que `Animal__c` y `Case` tienen un campo de texto auxiliar, `Centro_clave__c`, con el Id del centro. Las reglas comparten los registros con el rol de cada centro según ese campo. El campo solo existe en Salesforce, no en PostgreSQL.

## Cómo descargar los cambios de la org

Requiere [Salesforce CLI](https://developer.salesforce.com/tools/salesforcecli) y haber iniciado sesión (`sf org login web --alias mimo`).

```bash
cd salesforce
sf project retrieve start --manifest manifest/package.xml --target-org mimo
```

El archivo `manifest/package.xml` lista de forma explícita qué se descarga. Los roles de un centro nuevo hay que añadirlos a mano. Hay elementos que se dejan fuera a propósito: la *External Client App* (contiene credenciales) y los usuarios.

## Notas

- No hay claves ni secretos en este repositorio.
- Proyecto del TFG de DAM. Ver el README de la raíz para la visión general.
