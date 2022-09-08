# Basic calculator in python


import operator


def converter(operation):
    match operation:
        case "+":
            return operator.add
        case "-":
            return operator.sub
        case "*":
            return operator.sub
        case "/":
            return operator.truediv


def calculator():
    num1 = float(input("Enter the first number: "))
    num2 = float(input("Enter the second number: "))
    operation = input("Enter the operator: ")
    operation_converted = converter(operation)
    answer = operation_converted(num1, num2)
    print(round(answer, 5))


if __name__ == "__main__":
    run_var = True
    while run_var == True:
        calculator()
        continue_var = input("\nNew calculation? (y/n) ")
        if continue_var.lower() == "n":
            run_var = False
