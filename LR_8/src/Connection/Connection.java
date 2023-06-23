package Connection;

import java.io.*;
import java.net.Socket;
// Класс, отвечающий за соединение клиента с сервером
// сокет, который клиент и сервер используют для связи друг с другом. Клиент получает объект сокета, создав его,
// тогда как сервер получает объект сокета из возвращаемого значения метода accept().
public class Connection implements Closeable {
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    // В конструкторе принимаем объект класс socket, затем получаем потоки записи и чтения
    // Через эти потоки мы передаем сериализованный объект класса message
    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    //метод, отправляющий по сокетному соединению сообщение
    public void send(Message message) throws IOException {
        synchronized (this.out) {
            out.writeObject(message);
        }
    }

    //метод, принимающий сообщение по сокетному соединению
    public Message receive() throws IOException, ClassNotFoundException {
        synchronized (this.in) {
            Message message = (Message) in.readObject();
            return message;
        }
    }

    //метод, зарывающий потоки чтения, записи и сокет
    @Override
    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
}
