package com.javaprimary.b2_design_pattern;

public class A6_ChainOfResponsibility {

    public static void main(String[] args) {
        Leader a = new Director("张三");
        Leader b = new Manager("李四");
        Leader b2 = new ViceGeneralManager("李小四");
        Leader c = new GeneralManager("王五");
        //组织责任链对象的关系
        a.setNextLeader(b);
        b.setNextLeader(b2);
        b2.setNextLeader(c);

        //开始请假操作
        LeaveRequest req1 = new LeaveRequest("TOM", 15, "回英国老家探亲！");
        a.handleRequest(req1);
    }

    /**
     * 主任
     */
    public static class Director extends Leader {
        public Director(String name) {
            super(name);
        }

        @Override
        public void handleRequest(LeaveRequest request) {
            if (request.getLeaveDays() < 3) {
                System.out.println("员工：" + request.getEmpName() + "请假，天数：" + request.getLeaveDays() + ",理由：" + request.getReason());
                System.out.println("主任：" + this.name + ",审批通过！");
            } else {
                if (this.nextLeader != null) {
                    this.nextLeader.handleRequest(request);
                }
            }
        }
    }

    /**
     * 经理
     */
    public static class Manager extends Leader {
        public Manager(String name) {
            super(name);
        }

        @Override
        public void handleRequest(LeaveRequest request) {
            if (request.getLeaveDays() < 10) {
                System.out.println("员工：" + request.getEmpName() + "请假，天数：" + request.getLeaveDays() + ",理由：" + request.getReason());
                System.out.println("经理：" + this.name + ",审批通过！");
            } else {
                if (this.nextLeader != null) {
                    this.nextLeader.handleRequest(request);
                }
            }
        }
    }

    /**
     * 添加一个：副总经理
     */
    public static class ViceGeneralManager extends Leader {
        public ViceGeneralManager(String name) {
            super(name);
        }

        @Override
        public void handleRequest(LeaveRequest request) {
            if (request.getLeaveDays() < 20) {
                System.out.println("员工：" + request.getEmpName() + "请假，天数：" + request.getLeaveDays() + ",理由：" + request.getReason());
                System.out.println("副总经理：" + this.name + ",审批通过！");
            } else {
                if (this.nextLeader != null) {
                    this.nextLeader.handleRequest(request);
                }
            }
        }
    }

    /**
     * 总经理
     */
    public static class GeneralManager extends Leader {

        public GeneralManager(String name) {
            super(name);
        }

        @Override
        public void handleRequest(LeaveRequest request) {
            if (request.getLeaveDays() < 30) {
                System.out.println("员工：" + request.getEmpName() + "请假，天数：" + request.getLeaveDays() + ",理由：" + request.getReason());
                System.out.println("总经理：" + this.name + ",审批通过！");
            } else {
                System.out.println("莫非" + request.getEmpName() + "想辞职，居然请假" + request.getLeaveDays() + "天！");
            }
        }
    }

    /**
     * 抽象类
     */
    public abstract static class Leader {
        protected String name;
        protected Leader nextLeader; //责任链上的后继对象

        public Leader(String name) {
            super();
            this.name = name;
        }

        // 设定责任链上的后继对象
        public void setNextLeader(Leader nextLeader) {
            this.nextLeader = nextLeader;
        }

        /**
         * 处理请求的核心的业务方法
         */
        public abstract void handleRequest(LeaveRequest request);
    }

    /**
     * 封装请假的基本信息
     */
    public static class LeaveRequest {
        private String empName;
        private int leaveDays;
        private String reason;

        public LeaveRequest(String empName, int leaveDays, String reason) {
            super();
            this.empName = empName;
            this.leaveDays = leaveDays;
            this.reason = reason;
        }

        public String getEmpName() {
            return empName;
        }

        public void setEmpName(String empName) {
            this.empName = empName;
        }

        public int getLeaveDays() {
            return leaveDays;
        }

        public void setLeaveDays(int leaveDays) {
            this.leaveDays = leaveDays;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }
}


