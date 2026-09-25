import matplotlib.pyplot as plt


# ==========================================
# INPUT SIZES
# ==========================================

input_sizes = [1000, 5000, 10000, 20000]


# ==========================================
# SORTING - EXECUTION TIME
# Replace values with your actual results
# ==========================================

bubble_time = [0, 0, 0, 0]
selection_time = [0, 0, 0, 0]
insertion_time = [0, 0, 0, 0]
merge_time = [0, 0, 0, 0]
quick_time = [0, 0, 0, 0]


plt.figure(figsize=(10, 6))

plt.plot(input_sizes, bubble_time,
         marker='o', label='Bubble Sort')

plt.plot(input_sizes, selection_time,
         marker='o', label='Selection Sort')

plt.plot(input_sizes, insertion_time,
         marker='o', label='Insertion Sort')

plt.plot(input_sizes, merge_time,
         marker='o', label='Merge Sort')

plt.plot(input_sizes, quick_time,
         marker='o', label='Quick Sort')

plt.xlabel("Input Size")
plt.ylabel("Execution Time (ns)")

plt.title("Sorting Algorithms - Execution Time")

plt.legend()
plt.grid(True)

plt.savefig("sorting_execution_time.png")

plt.show()


# ==========================================
# SORTING - MEMORY
# ==========================================

bubble_memory = [0, 0, 0, 0]
selection_memory = [0, 0, 0, 0]
insertion_memory = [0, 0, 0, 0]
merge_memory = [0, 0, 0, 0]
quick_memory = [0, 0, 0, 0]


plt.figure(figsize=(10, 6))

plt.plot(input_sizes, bubble_memory,
         marker='o', label='Bubble Sort')

plt.plot(input_sizes, selection_memory,
         marker='o', label='Selection Sort')

plt.plot(input_sizes, insertion_memory,
         marker='o', label='Insertion Sort')

plt.plot(input_sizes, merge_memory,
         marker='o', label='Merge Sort')

plt.plot(input_sizes, quick_memory,
         marker='o', label='Quick Sort')

plt.xlabel("Input Size")
plt.ylabel("Memory Usage (bytes)")

plt.title("Sorting Algorithms - Memory Consumption")

plt.legend()
plt.grid(True)

plt.savefig("sorting_memory.png")

plt.show()


# ==========================================
# FIBONACCI - EXECUTION TIME
# ==========================================

fib_n = [10, 20, 25, 30, 35]

recursive_time = [0, 0, 0, 0, 0]
iterative_time = [0, 0, 0, 0, 0]


plt.figure(figsize=(10, 6))

plt.plot(fib_n, recursive_time,
         marker='o', label='Recursive Fibonacci')

plt.plot(fib_n, iterative_time,
         marker='o', label='Iterative Fibonacci')

plt.xlabel("Input n")
plt.ylabel("Execution Time (ns)")

plt.title("Fibonacci Algorithms - Execution Time")

plt.legend()
plt.grid(True)

plt.savefig("fibonacci_execution_time.png")

plt.show()


# ==========================================
# FIBONACCI - MEMORY
# ==========================================

recursive_memory = [0, 0, 0, 0, 0]
iterative_memory = [0, 0, 0, 0, 0]


plt.figure(figsize=(10, 6))

plt.plot(fib_n, recursive_memory,
         marker='o', label='Recursive Fibonacci')

plt.plot(fib_n, iterative_memory,
         marker='o', label='Iterative Fibonacci')

plt.xlabel("Input n")
plt.ylabel("Memory Usage (bytes)")

plt.title("Fibonacci Algorithms - Memory Consumption")

plt.legend()
plt.grid(True)

plt.savefig("fibonacci_memory.png")

plt.show()


print("All graphs generated successfully!")
