package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task {
	
	private static class TaskPair {
        private LocalDate date;
        private String content;

        public TaskPair(LocalDate date, String content) {
            this.date = date;
            this.content = content;
        }

        public LocalDate getDate() {
            return date;
        }

        public String getContent() {
            return content;
        }
    }

    private List<TaskPair> taskList = new ArrayList<>();
	
	public Task() {
		
		LocalDate[] dates = new LocalDate[]{
                LocalDate.of(2021, 10, 21),
                LocalDate.of(2021, 9, 15),
                LocalDate.of(2021, 12, 4),
                LocalDate.of(2021, 8, 10),
                LocalDate.of(2021, 11, 9),
        };

        String[] contents = new String[]{
                "牛乳を買う。",
                "○○社面談。",
                "手帳を買う。",
                "散髪に行く。",
                "スクールの課題を解く。",
        };
        
        for (int i = 0; i < dates.length; i++) {
            taskList.add(new TaskPair(dates[i], contents[i]));
        }
        
	}
	
	public void task() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");

        taskList.sort(Comparator.comparing(TaskPair::getDate));

        for (TaskPair task : taskList) {
            String formattedDate = dateTimeFormatter.format(task.getDate());
            System.out.println(formattedDate + " " + task.getContent());
        }
    }

}
