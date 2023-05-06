package by.it_academy.jd2.Mk_JD2_98_23.dao.memory.factory;

import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IArtistDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IVoteDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.memory.ArtistMemoryDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.memory.VoteMemoryDao;

public class VoteDaoFactory {
    private static IVoteDao instance;

    public VoteDaoFactory() {
    }

    public static IVoteDao getInstance(){
        if (instance == null) {
            synchronized (VoteDaoFactory.class) {
                if (instance == null) {
                    instance = new VoteMemoryDao() {
                    };
                }
            }
        }
        return instance;
    }
}
