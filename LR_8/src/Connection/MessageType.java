package Connection;
// Хранение типов сообщения
public enum MessageType {
    REQUEST_NAME_USER, // когда запрашивает сервер имя пользователя, отправляется сообщение типа...
    TEXT_MESSAGE, // сообщение для других пользователей(тип)
    NAME_ACCEPTED,
    USER_NAME,
    NAME_USED,
    USER_ADDED,
    DISABLE_USER,
    REMOVED_USER;
}