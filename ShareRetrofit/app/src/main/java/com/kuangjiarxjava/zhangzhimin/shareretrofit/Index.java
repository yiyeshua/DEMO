package com.kuangjiarxjava.zhangzhimin.shareretrofit;

import java.util.List;

/**
 * Created by zhangzhimin on 2016/8/14.
 */
public class Index {


    /**
     * create_time : 2012-09-11 16:56:21
     * description : 什么都可以
     * id : 1
     * song_list : []
     * thumbnail : null
     * title : new1
     * uid : 32452092
     * user : {"homepage":"http://www.douban.com/people/32452092","icon":"http://img3.douban.com/icon/u32452092-15.jpg","id":"32452092","title":"铅笔JOJOJO","uid":"32452092"}
     */

    private BoardBean board;
    /**
     * board : {"create_time":"2012-09-11 16:56:21","description":"什么都可以","id":"1","song_list":[],"thumbnail":null,"title":"new1","uid":"32452092","user":{"homepage":"http://www.douban.com/people/32452092","icon":"http://img3.douban.com/icon/u32452092-15.jpg","id":"32452092","title":"铅笔JOJOJO","uid":"32452092"}}
     * r : 0
     * song_list : []
     */

    private int r;
    private List<?> song_list;

    public BoardBean getBoard() {
        return board;
    }

    public void setBoard(BoardBean board) {
        this.board = board;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public List<?> getSong_list() {
        return song_list;
    }

    public void setSong_list(List<?> song_list) {
        this.song_list = song_list;
    }

    @Override
    public String toString() {
        return "Index{" +
                "board=" + board +
                ", r=" + r +
                ", song_list=" + song_list +
                '}';
    }

    public static class BoardBean {
        private String create_time;
        private String description;
        private String id;
        private Object thumbnail;
        private String title;
        private String uid;

        @Override
        public String toString() {
            return "BoardBean{" +
                    "create_time='" + create_time + '\'' +
                    ", description='" + description + '\'' +
                    ", id='" + id + '\'' +
                    ", thumbnail=" + thumbnail +
                    ", title='" + title + '\'' +
                    ", uid='" + uid + '\'' +
                    ", user=" + user +
                    ", song_list=" + song_list +
                    '}';
        }

        /**
         * homepage : http://www.douban.com/people/32452092
         * icon : http://img3.douban.com/icon/u32452092-15.jpg
         * id : 32452092
         * title : 铅笔JOJOJO
         * uid : 32452092
         */

        private UserBean user;
        private List<?> song_list;

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(Object thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public List<?> getSong_list() {
            return song_list;
        }

        public void setSong_list(List<?> song_list) {
            this.song_list = song_list;
        }

        public static class UserBean {
            private String homepage;
            private String icon;
            private String id;
            private String title;
            private String uid;

            public String getHomepage() {
                return homepage;
            }

            public void setHomepage(String homepage) {
                this.homepage = homepage;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            @Override
            public String toString() {
                return "UserBean{" +
                        "homepage='" + homepage + '\'' +
                        ", icon='" + icon + '\'' +
                        ", id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        ", uid='" + uid + '\'' +
                        '}';
            }
        }
    }
}
