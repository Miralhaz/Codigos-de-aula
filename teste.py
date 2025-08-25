import psutil
import pandas as pd

import psutil

for proc in psutil.process_iter():
        try:
            processName = proc.name()
            if (processName == "chrome"):
                print(processName , ' ; ', proc.cpu_percent(interval=2)) # Esse último comando é para pegar o consumo de VMS pelo processo
        except (psutil.NoSuchProcess, psutil.AccessDenied, psutil.ZombieProcess):
            pass