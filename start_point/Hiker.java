
public class Hiker {

    public int answer() {
        DiskLogger.getInstance().log("The answer is Six * Nine");
        return 6 * 9;
    }
}

class DiskLogger
{
public:
  static DiskLogger & getInstance() { return it; }
  void log(const std::string & message){...}
private:
  DiskLogger();
  static DiskLogger it;
};
