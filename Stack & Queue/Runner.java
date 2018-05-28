/**
 * Created by Siddhant on 31-Mar-18.
 */
public class Runner {

    public static void main(String[] args)
    {

       /*       CODE OF #CHkingCC CLASS...

        for (int i =0;i<1000000;i++) {
            CHkingGC t = new CHkingGC(i);
        }*/

      /*Stack s = new DynamicStack();
       s.push(32);
       s.push(43);
       s.display();
       s.push(11);
       s.display();
       s.pop();
        System.out.println(s.isEmpty());
        System.out.println(s.isFull());
        System.out.println(s.top());
        s.push(75);
        s.push(88);
        System.out.println(s);
        for (int i = 0;i<11;i++)
        {
            s.push(i);
        }
        System.out.println(s);
*/
        S_UsingQueue  sq = new S_UsingQueue();
        for (int i = 0; i < 100; i++) {
                sq.push(i);
            System.out.println(sq.toString());
        }

        /*Queue q = new Queue();
        q.enqueue(32);
        q.enqueue(40);
        q.display();

        q.dequeue();
        q.display();

        q.dequeue();
        q.display();*/

        /*QueueBetter q = new QueueBetter();
        q.enqueue(32);
        q.enqueue(40);
        q.display();

        q.dequeue();
        q.display();

        q.dequeue();
        q.display();*/

       /* QueueCircular q = new QueueCircular();
        q.enqueue(32);
        q.enqueue(40);
        q.display();

        q.dequeue();
        q.display();

        q.dequeue();
        q.display();
        */
    }

}
