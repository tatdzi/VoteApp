package by.it_academy.jd2.Mk_JD2_98_23.controllers.telegram;

import by.it_academy.jd2.Mk_JD2_98_23.service.api.IArtistService;
import by.it_academy.jd2.Mk_JD2_98_23.service.factory.ArtistServiceFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    private IArtistService artistService;

    public Bot() {
        this.artistService = ArtistServiceFactory.getInstance();
    }

    @Override
    public String getBotUsername() {
        return "tatdzi_bot";
    }

    @Override
    public String getBotToken() {
        return "6054325555:AAG3K-mV3UEWvnDMKJartQWwXd5gPbriJzE";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage().getText().equals("/start")){
            SendMessage sm = SendMessage.builder()
                    .chatId(update.getMessage().getChatId().toString())
                    .text(artistService.get().toString()).build();
            try {
                execute(sm);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
        Integer id = Integer.parseInt(update.getMessage().getText());
        SendMessage sm = SendMessage.builder()
                .chatId(update.getMessage().getChatId().toString())
                    .text(artistService.get(id).getName()).build();
            try {
                execute(sm);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
}
