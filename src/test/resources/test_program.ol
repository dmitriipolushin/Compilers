program Return5


class Test {
  int a;

{
  int returnZero(){
        return 0;
  }

}


}

class TestChild extends Test {


{
  int returnFive(){
        return 5;
  }

}


}

{




  void main()
        int ret;
        int retCh;
        int retCh2;
        Test test;
        TestChild tch;
  {
          test = new Test;
          tch = new TestChild;
          ret = test.returnZero();
          retCh = tch.returnZero();
          retCh2 = tch.returnFive();
          print(ret);
          print(retCh);
          print(retCh2);

  }

 }