# Introduccion al desarrollo de nuevas plataformas - A
Examen, Lugares Turisticos

Samir Diego, Chávez Cáceres

* MainActivity se encarga de mostrar el TimePickerDialog el cual al escoger una hora y presionar "set" se encarga de invocar a Utils.
* Utils se encarga de crear un pending intent que va a invocar AlarmReceiver a traves del AlarmManager un servicio nativo de android.
* AlarmReceiver se encarga de crear y mostrar la notificacion al momento que este sea invocado por el AlarmManager.

Es posible que la primera vez de uso, no aparezca la notificacion y al volver a abrir la app, 
nos solicite permisos para mostrar notificaciones.

Es importante que al momento de configurar la alarma consideremos que se esta usando el formato 24hrs, en caso de emulaciones la alarma es en base al reloj del dispositivo android, no del sistema operativo

Para el build estoy usando la version de Gradle 5.6.4 con el jdk 11.0.12 (importante)
