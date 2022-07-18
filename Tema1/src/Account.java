public class Account
{
    private int accountNo;
    private int amount;
    private int nationalId;

    public Account() { }

    public void deposit (int amount)
    {
        this.amount = amount;
    }
    public class NotEnoughMoneyException extends Exception
    {
        public NotEnoughMoneyException(String errorMessage)
        {
            super(errorMessage);
        }
    }
    public void withdraw (int amount) throws NotEnoughMoneyException
    {
        if (this.amount< amount)
            throw new NotEnoughMoneyException("Not enough money");
        else
            this.amount = this.amount - amount;
    }
    public class InvalidNationalIdException extends Exception
    {
        public InvalidNationalIdException(String errorMessage)
        {
            super(errorMessage);
        }
    }
    public void linkToNationalId (int nationalId) throws InvalidNationalIdException
    {
        if (nationalId==-1)
            throw new InvalidNationalIdException("National id is not valid");
        else
            this.nationalId = nationalId;
    }
    @Override
    public String toString()
    {
        return "amount="+this.amount+" nationalId="+this.nationalId;
    }

    public static void main(String[] args) throws NotEnoughMoneyException, InvalidNationalIdException {
        Account account1 = new Account();
        account1.deposit(200);
        System.out.println(account1);
        account1.withdraw(100);
        System.out.println(account1);
        account1.withdraw(101);
        account1.linkToNationalId(20);
        System.out.println(account1);
        account1.linkToNationalId(-1);
    }

}
