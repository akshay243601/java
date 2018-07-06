package com.akshay.designPattern;

class Currency {
	int amount;

	public Currency(int amount) {
		this.amount = amount;
	}
}

interface DispenserChain {
	void dispense(Currency currency);

	void nextDispense(DispenserChain nextChain);
}

class Dollar50$Dispenser implements DispenserChain {

	DispenserChain chain;

	@Override
	public void dispense(Currency currency) {
		if (currency.amount >= 50) {
			int reminder = currency.amount % 50;
			int notesCount = currency.amount / 50;
			System.out.println("Dispense : 50$ notes : " + notesCount);
			if (reminder != 0) {
				this.chain.dispense(new Currency(reminder));
			}
		} else {
			this.chain.dispense(currency);
		}
	}

	@Override
	public void nextDispense(DispenserChain nextChain) {
		this.chain = nextChain;
	}

}

class Dollar20$Dispenser implements DispenserChain {

	DispenserChain chain;

	@Override
	public void dispense(Currency currency) {
		if (currency.amount >= 20) {
			int reminder = currency.amount % 20;
			int notesCount = currency.amount / 20;
			System.out.println("Dispense : 20$ notes : " + notesCount);
			if (reminder != 0) {
				this.chain.dispense(new Currency(reminder));
			}
		} else {
			this.chain.dispense(currency);
		}
	}

	@Override
	public void nextDispense(DispenserChain nextChain) {
		this.chain = nextChain;
	}

}

class Dollar10$Dispenser implements DispenserChain {

	DispenserChain chain;

	@Override
	public void dispense(Currency currency) {

		if (currency.amount < 0) {
			System.out.println("Please enter in multiple of 10..");
		}

		if (currency.amount >= 10) {
			int reminder = currency.amount % 10;
			int notesCount = currency.amount / 10;
			System.out.println("Dispense : 10$ notes : " + notesCount);
			if (reminder != 0) {
				this.chain.dispense(new Currency(reminder));
			}
		} else {
			this.chain.dispense(currency);
		}
	}

	@Override
	public void nextDispense(DispenserChain nextChain) {
		this.chain = nextChain;
	}

}

public class ChainOfResponsibilityDesignPattern {

	public static void main(String[] args) {
		DispenserChain chain50 = new Dollar50$Dispenser();
		DispenserChain chain20 = new Dollar20$Dispenser();
		DispenserChain chain10 = new Dollar10$Dispenser();
		chain50.nextDispense(chain20);
		chain20.nextDispense(chain10);
		
		chain50.dispense(new Currency(2040));

		
	}

}
