"Simple calculator made using python and PyQt5"

import sys

from PyQt5 import QtWidgets as qw
from PyQt5.QtCore import Qt

from functools import partial

__version__ = "0.1"
__author__ = "Aditya"
ERROR_MSG = "ERROR"

# Creating a Qwindow subclass to set up calc GUI


class calcGUI(qw.QMainWindow):
    """Calc GUI"""

    def __init__(self):
        """Initialise view"""
        super().__init__()

        # window properties
        self.setWindowTitle("Calculator")
        self.setFixedSize(350, 250)

        # central window
        self.generalLayout = qw.QVBoxLayout()
        self._centralWidget = qw.QWidget(self)
        self.setCentralWidget(self._centralWidget)
        self._centralWidget.setLayout(self.generalLayout)

        self.createdisplay()
        self.createbuttons()

    def createdisplay(self):
        """create the display"""
        self.display = qw.QLineEdit()
        self.display.setFixedHeight(50)
        self.display.setAlignment(Qt.AlignRight)
        self.display.setReadOnly(True)
        self.generalLayout.addWidget(self.display)

    def createbuttons(self):
        """Create the buttons."""
        self.buttons = {}
        buttonsLayout = qw.QGridLayout()
        # Button text | position on the QGridLayout
        buttons = {'7': (0, 0),
                   '8': (0, 1),
                   '9': (0, 2),
                   '/': (0, 3),
                   'C': (0, 4),
                   '4': (1, 0),
                   '5': (1, 1),
                   '6': (1, 2),
                   '*': (1, 3),
                   '(': (1, 4),
                   '1': (2, 0),
                   '2': (2, 1),
                   '3': (2, 2),
                   '-': (2, 3),
                   ')': (2, 4),
                   '0': (3, 0),
                   '00': (3, 1),
                   '.': (3, 2),
                   '+': (3, 3),
                   '=': (3, 4),
                   }
        # creating buttons and adding to grid layout
        for btnText, pos in buttons.items():
            self.buttons[btnText] = qw.QPushButton(btnText)
            self.buttons[btnText].setFixedSize(70, 50)
            buttonsLayout.addWidget(self.buttons[btnText], pos[0], pos[1])
        self.generalLayout.addLayout(buttonsLayout)

    def setDisplayText(self, text):
        """set display's text"""
        self.display.setText(text)
        self.display.setFocus()

    def displayText(self):
        """Get display text"""
        return self.display.text()

    def clearDisplay(self):
        """Clear the display"""
        self.setDisplayText('')


class calcControl:
    """Calc controller class"""

    def __init__(self, model, view):
        """Controller initialiser"""
        self._evaluate = model
        self._view = view
        self._connectSignals()

    def _calculateResult(self):
        """Evaluate expressions."""
        result = self._evaluate(expression=self._view.displayText())
        self._view.setDisplayText(result)

    def _buildExpression(self, sub_exp):
        """Build expression"""
        if self._view.displayText() == ERROR_MSG:
            self._view.clearDisplay()
        expression = self._view.displayText() + sub_exp
        self._view.setDisplayText(expression)

    def _connectSignals(self):
        """connect signals and slots"""
        for btnText, btn in self._view.buttons.items():
            if btnText not in ["=", "C"]:
                btn.clicked.connect(partial(self._buildExpression, btnText))

        self._view.buttons['='].clicked.connect(self._calculateResult)
        self._view.display.returnPressed.connect(self._calculateResult)
        self._view.buttons['C'].clicked.connect(self._view.clearDisplay)


def calculate(expression):
    """Calculate the answer"""
    try:
        result = str(eval(expression, {}, {}))
    except Exception:
        result = ERROR_MSG

    return result


def main():
    """Main function"""
    calc = qw.QApplication(sys.argv)
    view = calcGUI()

    view.show()

    model = calculate
    calcControl(model=model, view=view)

    sys.exit(calc.exec())


if __name__ == "__main__":
    main()
