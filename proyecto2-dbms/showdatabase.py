import os



nombre=input ("Ingrese el comando para mostrar tablas  ")
print ("Valid")
for file in os.listdir("."):
    if file.endswith(".txt"):
        print(os.path.join(".", file))