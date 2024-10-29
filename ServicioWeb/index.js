const express = require('express');
const mysql = require('mysql2');

// Crear una instancia de Express
const app = express();

// Configuración de la conexión a la base de datos MySQL
const db = mysql.createConnection({
    host: 'localhost',      // Cambia si tienes otro host
    user: 'root',      // Cambia por tu usuario de MySQL
    password: '', // Cambia por tu contraseña de MySQL
    database: 'puntos' // Nombre de la base de datos
});

// Conectar a la base de datos
db.connect(err => {
    if (err) {
        console.error('Error al conectar a la base de datos:', err);
        return;
    }
    console.log('Conectado a la base de datos MySQL');
});

// Ruta GET para obtener todos los puntos
app.get('/api/puntos', (req, res) => {
    const query = 'SELECT * FROM puntos';
    db.query(query, (err, results) => {
        if (err) {
            console.error('Error al obtener los datos:', err);
            res.status(500).send('Error en el servidor');
            return;
        }
        res.json(results);
    });
});

// Iniciar el servidor en el puerto 3000
const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Servidor corriendo en http://localhost:${PORT}`);
});
