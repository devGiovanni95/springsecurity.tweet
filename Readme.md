# Generate a Key with SSL

with the command below we can generate a private key 
* openssl genrsa > app.key

with the command below we can generate a public key 
* openssl rsa -in app.key -pubout -out app.pub

