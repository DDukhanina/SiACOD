import random
import time
from matplotlib import pyplot as plt
from matplotlib.ticker import StrMethodFormatter


def happy(N):
    sumbefore = sum(N)
    sumafter = 0
    for i in range(len(N)-1, 0, -1):
        sumbefore -= N[i]
        sumafter += N[i]
        if sumafter == sumbefore:
            return True
    return False

size = [100000, 200000, 300000, 400000, 500000]
mood = []
times = []
for i in range(len(size)):
    start_time = time.time()
    N = [random.randint(0, 100000) for j in range(size[i])]
    if happy(N):
        mood.append("Счастливый")
    else:
        mood.append("Несчастный")
    end_time = time.time()
    execution_time = end_time - start_time
    times.append(float(format(execution_time, ".6f")))

print(mood)
print(times)
plt.plot(size, times)
plt.gca().yaxis.set_major_formatter(StrMethodFormatter('{x:.6f}'))
plt.title('График')
plt.show()
