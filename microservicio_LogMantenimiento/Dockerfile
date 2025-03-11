# Usamos la imagen oficial de MongoDB
FROM mongo:latest

# Exponemos el puerto por defecto de MongoDB
EXPOSE 27017

# Variable de entorno para inicializar el usuario y la contraseña
# (opcional, elimina o comenta estas líneas si no necesitas autenticación)
#ENV MONGO_INITDB_ROOT_USERNAME=
#ENV MONGO_INITDB_ROOT_PASSWORD=

# El contenedor se iniciará con el comando por defecto de MongoDB
CMD ["mongod"]
