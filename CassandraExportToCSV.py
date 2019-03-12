import subprocess
import sys


get_table_details = """cqlsh --ssl --request-timeout=60 -e "
    select * from database.table limit 5
    ;"
    """

process = subprocess.Popen([get_table_details], shell=True, stdin=subprocess.PIPE, stdout=subprocess.PIPE,
                           stderr=subprocess.PIPE)
output = process.stdout.read()

output1 = output.split("\n")

lines = [line for line in output1 if line.strip()]

# out ==> a list of string, each row consists atomic rows of the output

out = lines[2:-1][::-1]

row = ""

finalOut = """"""

for a in out:
    b = a.split("|")
    for i in b:
        row = row + "|'" + i.strip() + "'"
    finalOut = finalOut + "\n" + row[1:]
    row = ""
print(finalOut)
