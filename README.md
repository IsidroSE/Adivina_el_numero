# Adivina_el_numero
Juego que hice en 2º de DAM donde mediante threads y funciones synchronized se crea una pequeña inteligencia artifical.
Se crea un número definido de jugadores (threads) que automaticamente preguntan al árbitro si es su turno, 
en el caso de que no lo sea esperarán 1 segundo y volverán a preguntar si ya es su turno, y en el caso de que
sea su turno, generaran de forma aleatoria un número y le preguntarán al árbitro si han acertado el número, este
número será añadido a una lista que se usará para que el jugador no pueda repetir elegir por el mismo número 2 veces.
