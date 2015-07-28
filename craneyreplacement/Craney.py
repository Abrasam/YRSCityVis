import csv
dictionary = {}
def find(data, name):
    with open('coords.csv', 'rU') as csvfile:
        spamreader = csv.reader(csvfile, delimiter=' ', quotechar='|')
        for row in spamreader:
            row = row[0]
            row = row.split(',')
            if row[0]==data:
                print ("Coords: " + row[4] + ", " + row[3])
                with open('output.txt', 'a') as file:
                    file.write(name + " " + row[4] + ", " + row[3] + "\n")
                    file.flush()
                return True;
while True:
    name = str(raw_input("Slave! Write: "))
    if name == "close":
        break;
    full = name;
    if len(name.split()) > 1:
        name = name.split()[0]
    with open('names.csv', 'rU') as csvfile:
        spamreader = csv.reader(csvfile, delimiter=' ', quotechar='|')
        for row in spamreader:
            row = row[0]
            row = row.split(",")
            if row[3] == name:
                item = find(row[0], full)
                if item:
                    break;
