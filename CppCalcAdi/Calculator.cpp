#include <iostream>
#include <iomanip>
using namespace std;

int main() {
	bool run;

	do {
		float x, y, ans;
		char sym, again;

		cout << "Enter the function to calculate (Ex: 2 * 3): ";
		cin >> x >> sym >> y;
		
		switch (sym) {
		case '+':
			ans = x + y;
			break;

		case '-':
			ans = x - y;
			break;

		case '*':
			ans = x * y;
			break;

		case '/':
			ans = x / y;
			break;

		default:
			ans = 0;
		}

		cout << x << " " << sym << " " << y << " = " << ans << endl;

		cout << "Do another calculation? (y/n) ";
		cin >> again;

		if (again == 'y') {
			run = true;
		}
		else {
			run = false;
		}

	} while (run);
	cout << "Goodbye!";
	return 0;
}