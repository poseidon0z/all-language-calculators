import operator
import math
import matplotlib.pyplot as plt
import numpy as np


def choice_converter(choice):
    match choice:
        case "+":
            return operator.add
        case "-":
            return operator.sub
        case "*":
            return operator.mul
        case "/":
            return operator.truediv
        case "^":
            return operator.pow
        case "sin":
            return math.sin
        case "cos":
            return math.cos
        case "tan":
            return math.tan
        case "sin-1":
            return math.asin
        case "cos-1":
            return math.acos
        case "tan-1":
            return math.atan
        case "exit":
            return "exit"
        case default:
            return "invalid"


def graphing(calculation):
    """Create a graph of trigonometric calculations"""
    # 100 linearly spaced numbers for x axis, between -pi and pi
    x = np.linspace(-np.pi, np.pi, 100)
    y = calculation(x)

    # setting the axes at the centre
    fig = plt.figure()
    ax = fig.add_subplot(1, 1, 1)
    ax.spines['left'].set_position('center')
    ax.spines['bottom'].set_position('center')
    ax.spines['right'].set_color('none')
    ax.spines['top'].set_color('none')
    ax.xaxis.set_ticks_position('bottom')
    ax.yaxis.set_ticks_position('left')

    # changing x axis labels
    radian_multiples = [-2, -3/2, -1, -1/2, 0,
                        1/2, 1, 3/2, 2]  # x_labels in radians
    radians = [n * np.pi for n in radian_multiples]
    radian_labels = ['$-2\pi$', '$-3\pi/2$', '$\pi$',
                     '$-\pi/2$', '0', '$\pi/2$', '$\pi$', '$3\pi/2$', '$2\pi$']
    plt.xticks(radians, radian_labels)

    # plot the function
    plt.plot(x, y, 'b-')

    # show the plot
    plt.show()


def calculator():
    """
    Main Function
    Takes input in the form of int, 
    and performs required calculation
    """
    print("""I - Simple Calculator
    -------------------------
    enter + to Add
    enter - to Subtract
    enter * to Multiply
    enter / to Divide
    enter ^ to find the Power and Square Root of the Base

    II - Trigonometric Calculator
    ----------------
    Enter sin to find Sin values
    Enter cos to find Cos values
    Enter tan to find Tan values

    III - Inverse Trigonometric Calculator
    -------------------------
    Enter sin-1 to find Sin Inverse values
    Enter cos-1 to find Cos Inverse values
    Enter tan-1 to find Tan Inverse values
    ----------------------------------
    Enter exit to Exit the Program
    ----------------------------------""")

    choice = input("Enter your choice: ")

    choice_operator = choice_converter(choice)

    if choice in ["+", "-", "*", "/", "^"]:
        num1 = float(input("Enter first number: "))
        num2 = float(input("Enter second number: "))

        answer = choice_operator(num1, num2)

    elif choice in ["sin", "cos", "tan"]:
        number = float(input("Enter angle in degrees: "))
        number_in_radians = math.radians(number)

        answer = choice_operator(number_in_radians)

    elif choice in ["sin-1", "cos-1", "tan-1"]:
        number = float(input("Enter value to find inverse: "))

        answer = choice_operator(number)

    elif choice_operator in ["exit", "invalid"]:
        if choice_operator == "invalid":
            print("Please enter a valid choice!")
        print("Quitting the calculator")
        return

    print(round(answer, 5))

    if choice in ["sin", "cos", "tan", "sin-1", "cos-1", "tan-1"]:
        graphing(choice_operator)


if __name__ == "__main__":
    run_variable = True
    while run_variable == True:
        run_variable = False
        calculator()
        reply = input("Do another calculation? (y/n): ")
        if reply.capitalize() == "Y":
            run_variable = True
