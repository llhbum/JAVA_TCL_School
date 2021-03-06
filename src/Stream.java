
import java.util.logging.SocketHandler;

public class Stream {
    public static void main(String[] args)  {
        /*
        ** 스트림
            * 스트림
                - 자바에서는 파일이나 콘솔의 입출력을 직접 다루지 않고, 스트림이라는 흐름을 통해 다룹니다.
                - 스트림이란 실제의 입력이나 출력이 표현한 데이터의 이상화된 흐름을 의미합니다.
                - 즉, 스트림은 운영체제에 의해 생성되는 가상의 연결고리를 의미하며, 중간 매개자 역할을 합니다.

                - JAVA se 8 버전부터 추가된 스트림 API는 앞서 설명한 스트림과는 전혀 다른 개념입니다.

            * 입출력 스트림
                - 스트림은 한 방향으로만 통신할 수 있으므로, 입력과 출력을 동시에 처리할 수는 없습니다.
                - 따라서 스트림은 사용 목적에 따라 입력 스트림과 출력 스트림으로 구분됩니다.

                - 자바에서는 java.io 패키지를 통해 InputStream과 OutputStream 클래스를 별도로 제공하고 있습니다.
                - 즉, 자바에서의 스트림 생성이란 이러한 스트림 클래스 타입의 인스턴스를 생성한다는 의미입니다.

                - InputStream 클래스에는 read() 메소드가, OutputStream 클래스에는 write() 메소드가 각각 추상 메소드로 포함되어 있습니다.
                - 사용자는 이 두 메소드를 상황에 맞게 적절히 구현해야만 입출력 스트림을 생성하여 사용할 수 있습니다.

            * 바이트 기반 스트림
                - 자바에서 스트림은 기본적으로 바이트 단위로 데이터를 전송합니다.

            * 보조 스트림
                - 자바에서 제공하는 보조 스트림은 실제로 데이터를 주고받을 수는 없지만, 다른 스트림의 기능을 향상시키거나 새로운 기능을 추가해 주는 스트림입니다.

            * 문자 기반 스트림
                - 자바에서 스트림은 기본적으로 바이트 단위로 데이터를 전송합니다.
                - 하지만 자바에서 가장 작은 타입인 char 형이 2바이트이므로, 1바이트씩 전송되는 바이트 기반 스트림으로는 원활한 처리가 힘든 경우가 있습니다.
                - 따라서 자바에서는 바이트 기반 스트림뿐만 아니라 문자 기반의 스트림도 별도로 제공합니다.
                - 이러한 문자 기반 스트림은 기존의 바이트 기반 스트림에서 InputStream을 Reader로, OutputStream을 Write로 변경하면 사용할 수 있습니다.

        ** 파일 입출력
            * 표준 입출력
                - 자바에서는 콘솔과 같은 표준 입출력 장치를 위해 System이라는 표준 입출력 클래스를 정의하고 있습니다.
                - java.lang 패키지에 포함되어 있는 System 클래스는 표준 입출력을 위해 다음과 같은 클래스 변수를 제공합니다.
                클래스 변수 / 입출력 스트림 / 설명
                System.in / InputStream / 콘솔로부터 데이터를 입력받음.
                System.out / PrintStream / 콘솔로 데이터를 출력함.
                System.err / PrintStream / 콘솔로 데이터를 출력함
                - 표준 입출력 스트림은 자바가 자동으로 생성하므로, 개발자가 별도로 스트림을 생성하지 않아도 사용할 수 있습니다.

            * 표준 입출력의 대상 변경
                - 앞서 살펴본 세 가지 입출력 스트림은 모두 콘솔과 같은 표준 입출력 장치를 대상으로 합니다.
                - 하지만 이와 같은 스트림에 다음 System 메소드를 사용하면 스트림의 대상을 다른 입출력장치로 변경할 수 있습니다.
                메소드 / 설명
                static void setIn(InputStream in) / 입력 스트림의 대상을 전달된 입력 스트림으로 변경함.
                static void SetOut(PrintSteam out) / 출력 스트림의 대상을 전달된 출력 스트림으로 변경함.
                static void setErr(PrintStream err) / 출력 스트림의 대상을 전달된 출력 스트림으로 변경함.

            * RandomAccessFile 클래스
                 - 앞서 살펴본 다양한 입출력 스트림을 이용하면 다음에 순차적으로 입출력 작업을 수행할 수 있습니다.
                 - 하지만 순차적인 접근이 아닌 임의의 지점에 접근하여 작업을 수행하고 싶다면, RandomAccessFile 클래스를 사용하면 됩니다.
                 - 이 클래스는 파일만을 대상으로 하며, 임의의 지점에서 입출력을 동시에 수행할 수 있습니다.

                 - RandomAccessFile 클래스의 생성자에는 인수로 파일의 이름뿐만 아니라 파일 모드까지 함께 전달해야 합니다.
                 - 파일 모드란 파일의 사용 용도를 나타내는 문자열로, 자바에서 사용할 수 있는 대표적인 파일 모드는 다음과 같습니다.
                 파일모드 / 설명
                 "r" / 파일을 오로지 읽는 것만 가능한 모드로 개방함
                 "rw" / 파일을 읽고 쓰는 것이 모두 가능한 모드로 개방함, 만약 파일이 없으면 새로운 파일을 생성함

                 - getFilePointer() 메소드를 사용하면 파일 포인터의 현재 위치를 확인할 수 있습니다.
                 - 또한 seek()메소드를 사용하면 파일 포인터의 위치를 변경할 수도 있습니다.

            * File 클래스
                 - 앞서 살펴본 입출력 스트림을 사용하면 파일을 통한 입출력 작업을 수행항 수 있습니다.
                 - 하지만 파일의 제거나 디렉터리에 관한 작업 등은 입출력 스트림을 통해서는 수행할 수 없습니다.
                 - 자바는 이러한 입출력 작업 이외의 파일과 디렉터리에 관한 작업을 File 클래스를 통해 처리하도록 하고 있습니다.

        */


    }
}
